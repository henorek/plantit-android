package net.henorek.plantit.data.cache;

interface DateProvider {

    long now();

    DateProvider SYSTEM = () -> System.currentTimeMillis();
}
