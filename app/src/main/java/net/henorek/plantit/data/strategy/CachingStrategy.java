package net.henorek.plantit.data.strategy;

/**
 * Created by Michał Seroczyński (michal.seroczynski@audioteka.com) on 15.01.16.
 */
public interface CachingStrategy<T> {
    boolean isValid(T data);
}
