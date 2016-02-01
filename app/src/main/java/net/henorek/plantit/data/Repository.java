package net.henorek.plantit.data;


import net.henorek.plantit.data.cache.ICacheDataStore;
import net.henorek.plantit.data.disk.entity.Tactic;
import net.henorek.plantit.data.enums.SourceType;
import net.henorek.plantit.data.net.api.ITacticsApiDataSource;
import net.henorek.plantit.data.strategy.list.ListCachingStrategy;
import net.henorek.plantit.data.strategy.notnull.NotNullCachingStrategy;
import net.henorek.plantit.data.util.RxUtil;
import net.henorek.plantit.di.scope.ApplicationScope;

import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;
import rx.Observable;

@ApplicationScope
public class Repository implements IRepository {

  private final Lazy<ICacheDataStore> cache;
  private final Lazy<IDiskDataStore> disk;
  private final Lazy<ITacticsApiDataSource> api;

  @Inject
  public Repository(Lazy<ICacheDataStore> cache, Lazy<IDiskDataStore> disk, Lazy<ITacticsApiDataSource> api) {
    this.cache = cache;
    this.disk = disk;
    this.api = api;
  }

  @Override
  public Observable<List<Tactic>> getTactics(String title, boolean forceRefresh) {

    NotNullCachingStrategy<Tactic> ce = new NotNullCachingStrategy<>();
    ListCachingStrategy<Tactic> lcs = new ListCachingStrategy<>(ce);

    Observable<List<Tactic>> cacheObservable = cache.get()
        .getTactics(title)
            .compose(RxUtil.applyLog(SourceType.CACHE));

    Observable<List<Tactic>> diskObservable = disk.get()
        .getTactics(title)
            .doOnNext(chapters -> cache.get().put(title, chapters))
        .compose(RxUtil.applyLog(SourceType.DISK));

    Observable<List<Tactic>> apiObservable = api.get()
        .getTactics(title)
            .doOnNext(chapters -> disk.get().save(chapters))
        .doOnNext(chapters -> cache.get().put(title, chapters))
        .compose(RxUtil.applyLog(SourceType.API));

    // TODO to powinien załatwiać pierwszy filtr strategii cache'owania
    // chociaż z drugiej strony to jest kontekstowe,
    // strategia cache'owania nie musi okreslac sposobu postepowania z kazdym z typow

    // TODO w zależności od internetu lub braku zwracać

    return forceRefresh ? apiObservable
        : Observable.concat(cacheObservable, diskObservable, apiObservable)
        .first(chapters -> (chapters != null && chapters.size() > 0));
  }
}
