package com.henorek.plantit.data;

import android.content.Context;
import com.github.pwittchen.reactivenetwork.library.ReactiveNetwork;
import com.henorek.plantit.data.disk.entity.Tactic;
import com.henorek.plantit.data.enums.SourceType;
import com.henorek.plantit.data.net.api.ITacticsApiDataSource;
import com.henorek.plantit.data.utils.RxDataUtils;
import com.henorek.plantit.di.scope.ApplicationScope;
import com.henorek.plantit.utils.RxUtils;
import dagger.Lazy;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscription;

@ApplicationScope public class Repository implements IRepository {

  private final Lazy<IDiskDataStore> disk;
  private final Lazy<ITacticsApiDataSource> api;
  private final Context context;

  @Inject
  public Repository(Lazy<IDiskDataStore> disk, Lazy<ITacticsApiDataSource> api, Context context) {
    this.disk = disk;
    this.api = api;
    this.context = context;
  }

  @Override public Observable<List<Tactic>> getTactics(boolean forceRefresh) {

    Observable<List<Tactic>> diskObservable =
        disk.get().getTactics().compose(RxDataUtils.applyLog(SourceType.DISK));

    Observable<List<Tactic>> apiObservable = api.get()
        .getTactics()
        .doOnNext(tactics -> disk.get().save(tactics))
        .compose(RxDataUtils.applyLog(SourceType.API));

    Subscription connectivityStatusSubscription = new ReactiveNetwork().observeConnectivity(context)
        .compose(RxUtils.applySchedulers())
        .subscribe(connectivityStatus -> {
          if (RxDataUtils.isConnected(connectivityStatus)) System.out.println("dupa");
        });

    return forceRefresh ? apiObservable : Observable.concat(diskObservable, apiObservable)
        .first(tactics -> (tactics != null && tactics.size() > 0));
  }
}
