package net.henorek.plantit.data.cache;

class CacheBean<T> {

    private long creationDate;
    private long keepAliveInMillis;
    private T value;

    public CacheBean(T value, long creationDate, long keepAliveInMillis) {
        this.creationDate = creationDate;
        this.keepAliveInMillis = keepAliveInMillis;
        this.value = value;
    }

    public boolean isAlive(long now) {
        return Cache.KEEPALIVE_FOREVER == keepAliveInMillis || creationDate + keepAliveInMillis > now;
    }

    public T getValue() {
        return value;
    }
}