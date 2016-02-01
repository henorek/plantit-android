package net.henorek.plantit.data.cache;

public class CacheBuilder {
    private boolean caseSensitiveKeys = true;
    private Integer autoReleaseInSeconds = null;
    private long defaultKeepaliveInMillis = Cache.KEEPALIVE_FOREVER;

    public CacheBuilder setCaseSensitiveKeys(boolean caseSensitiveKeys) {
        this.caseSensitiveKeys = caseSensitiveKeys;
        return this;
    }

    public CacheBuilder setAutoReleaseInSeconds(Integer autoReleaseInSeconds) {
        this.autoReleaseInSeconds = autoReleaseInSeconds;
        return this;
    }

    public CacheBuilder setDefaultKeepaliveInMillis(long defaultKeepaliveInMillis) {
        this.defaultKeepaliveInMillis = defaultKeepaliveInMillis;
        return this;
    }

    public <T> Cache<T> createQNCache() {
        return new Cache<T>(caseSensitiveKeys, autoReleaseInSeconds, defaultKeepaliveInMillis);
    }
}