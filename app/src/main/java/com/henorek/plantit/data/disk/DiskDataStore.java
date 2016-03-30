package com.henorek.plantit.data.disk;

import com.henorek.plantit.data.IDiskDataStore;
import com.henorek.plantit.data.disk.dao.TacticDao;
import com.henorek.plantit.data.disk.entity.Tactic;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

public class DiskDataStore implements IDiskDataStore {

  private TacticDao dao;

  @Inject public DiskDataStore(TacticDao dao) {
    this.dao = dao;
  }

  @Override public Observable<List<Tactic>> getTactics() {
    return Observable.just(get());
  }

  @Override public List<Tactic> get() {
    return dao.getTactics();
  }

  @Override public void save(List<Tactic> tactics) {
    dao.save(tactics);
  }
}
