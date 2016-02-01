package net.henorek.plantit.data.strategy.list;

import net.henorek.plantit.data.strategy.CachingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał Seroczyński (michal.seroczynski@audioteka.com) on 15.01.16.
 */
public class ListCachingStrategy<T> implements CachingStrategy<List<T>> {

    private final CachingStrategy<T> cachingStrategy;

    public ListCachingStrategy(CachingStrategy<T> cachingStrategy) {
        this.cachingStrategy = cachingStrategy;
    }

    @Override
    public boolean isValid(List<T> data) {
        if (data == null || data.size() == 0) {
            return false;
        }

        for (T single : data) {
            if (!isValidSingle(single)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidSingle(T data) {
        return cachingStrategy.isValid(data);
    }

    public List<T> candidatesToPurgue(List<T> data) {
        ArrayList<T> purgue = new ArrayList<>();
        for (T single : data) {
            if (!isValidSingle(single)) {
                purgue.add(single);
            }
        }
        return purgue;
    }

}
