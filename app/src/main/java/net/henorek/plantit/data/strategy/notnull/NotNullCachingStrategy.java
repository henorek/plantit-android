package net.henorek.plantit.data.strategy.notnull;

import net.henorek.plantit.data.strategy.CachingStrategy;

public class NotNullCachingStrategy<T> implements CachingStrategy<T> {
    @Override
    public boolean isValid(T data) {
        return data != null;
    }
}