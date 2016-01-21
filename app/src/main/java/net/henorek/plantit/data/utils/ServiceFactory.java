package net.henorek.plantit.data.utils;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Jarek Jankowski on 2016-01-21.
 * jarosz1994@gmail.com
 */
public class ServiceFactory {

    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
        final Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        T service = restAdapter.create(clazz);
        return service;
    }
}
