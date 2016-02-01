package net.henorek.plantit.data.cache;


import net.henorek.plantit.data.disk.entity.Tactic;

import java.util.List;

import rx.Observable;

public interface ITacticCache {

    Observable<List<Tactic>> get(String title);

    void put(String title, List<Tactic> chapters);

    boolean isCached(String title);

}
