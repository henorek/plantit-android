package net.henorek.plantit.data.cache;

import net.henorek.plantit.data.disk.entity.Tactic;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Michał Seroczyński (michal.seroczynski@audioteka.com) on 08.01.16.
 */
public class CacheDataStore implements ICacheDataStore {

    private Cache<List<Tactic>> cache;

    @Inject
    public CacheDataStore(Cache<List<Tactic>> cache) {
        this.cache = cache;
    }

    public Observable<List<Tactic>> get(String title) {
        return Observable.just(cache.get(title));
    }

    public void put(String title, List<Tactic> chapters) {
        cache.set(title, chapters);
    }

    public boolean isCached(String title) {
        return cache.contains(title);
    }

    @Override
    public Observable<List<Tactic>> getTactics(String title) {
        return get(title);
    }

}
