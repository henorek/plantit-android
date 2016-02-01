package net.henorek.plantit.data.strategy.ttl;

import com.audioteka.data.strategy.CachingStrategy;

import java.util.concurrent.TimeUnit;

/**
 * Created by Michał Seroczyński (michal.seroczynski@audioteka.com) on 15.01.16.
 */
public class TtlCachingStrategy<T extends TtlCachingObject> implements CachingStrategy<T> {

    private final long ttlMillis;

    public TtlCachingStrategy(int ttl, TimeUnit timeUnit) {
        ttlMillis = timeUnit.toMillis(ttl);
    }

    @Override
    public boolean isValid(T data) {
        return (data.getPersistedTime() + ttlMillis) > System.currentTimeMillis();
    }

}
