package net.henorek.plantit.data.cache;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Cache<T> {

    public static final long KEEPALIVE_FOREVER = 0;

    private boolean caseSensitiveKeys = true;
    private Integer autoReleaseInSeconds = null;
    private Long defaultKeepaliveInMillis = null;
    private DateProvider dateProvider = DateProvider.SYSTEM;

    public Cache(boolean caseSensitiveKeys, Integer autoReleaseInSeconds, Long defaultKeepaliveInMillis) {
        this.caseSensitiveKeys = caseSensitiveKeys;
        if (autoReleaseInSeconds != null && autoReleaseInSeconds > 0) {
            this.autoReleaseInSeconds = autoReleaseInSeconds;
        }
        if (defaultKeepaliveInMillis != null && defaultKeepaliveInMillis > 0) {
            this.defaultKeepaliveInMillis = defaultKeepaliveInMillis;
        }

        cache = new ConcurrentHashMap<>();

        startAutoReleaseServiceIfNeeded();
    }

    private void startAutoReleaseServiceIfNeeded() {
        if (autoReleaseInSeconds != null) {
            ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

            ses.scheduleAtFixedRate(this::removeTooOldValues, autoReleaseInSeconds, autoReleaseInSeconds, TimeUnit.SECONDS);
        }
    }

    boolean isCaseSensitiveKeys() {
        return caseSensitiveKeys;
    }

    Integer getAutoReleaseInSeconds() {
        return autoReleaseInSeconds;
    }

    Long getDefaultKeepaliveInMillis() {
        return defaultKeepaliveInMillis;
    }

    private long now() {
        return dateProvider.now();
    }

    protected void setDateProvider(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    private ConcurrentHashMap<String, CacheBean<T>> cache;

    public void set(String key, T value) {
        if (defaultKeepaliveInMillis != null) {
            set(key, value, defaultKeepaliveInMillis);
        } else {
            set(key, value, KEEPALIVE_FOREVER);
        }
    }

    public void set(String key, T value, long keepAliveInMillis) {
        key = getEffectiveKey(key);

        if (keepAliveInMillis >= 0) {
            cache.put(key, new CacheBean<T>(value, now(), keepAliveInMillis));
        }
    }

    public T get(String key) {
        key = getEffectiveKey(key);

        CacheBean<T> retrievedValue = cache.get(key);
        if (retrievedValue == null || !retrievedValue.isAlive(now())) {
            return null;
        } else {
            return retrievedValue.getValue();
        }
    }

    T getAndRemoveIfDead(String key) {
        key = getEffectiveKey(key);

        CacheBean<T> retrievedValue = cache.get(key);
        if (retrievedValue == null) {
            return null;
        } else if (retrievedValue.isAlive(now())) {
            return retrievedValue.getValue();
        } else {
            cache.remove(key);
            return null;
        }
    }

    public void remove(String key) {
        key = getEffectiveKey(key);

        cache.remove(key);
    }

    public void removeAll() {
        cache.clear();
    }

    void removeTooOldValues() {
        Iterator<Map.Entry<String, CacheBean<T>>> it = cache.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, CacheBean<T>> entry = it.next();
            CacheBean<T> bean = entry.getValue();
            if (!bean.isAlive(now())) {
                it.remove();
            }
        }
    }

    public int size() {
        return sizeCountingOnlyAliveElements();
    }

    int sizeCountingOnlyAliveElements() {
        int size = 0;

        for(CacheBean<T> cacheValue: cache.values()) {
            if (cacheValue.isAlive(now())) {
                size++;
            }
        }
        return size;
    }

    int sizeCountingDeadAndAliveElements() {
        return cache.size();
    }

    public boolean isEmpty() {
        return sizeCountingOnlyAliveElements() == 0;
    }

    public boolean contains(String key) {
        key = getEffectiveKey(key);

        return get(key) != null;
    }

    private String getEffectiveKey(String key) {
        if (!caseSensitiveKeys) {
            return key.toLowerCase();
        }
        return key;
    }
}