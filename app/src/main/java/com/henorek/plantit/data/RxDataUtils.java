package com.henorek.plantit.data;

import com.github.pwittchen.reactivenetwork.library.ConnectivityStatus;

import com.henorek.plantit.BuildConfig;
import com.henorek.plantit.data.enums.SourceType;

import java.util.List;

import rx.Observable;
import timber.log.Timber;

public class RxDataUtils {

    /**
     * This method is responsible for applying current data source log
     * - author Michał Seroczyński
     */
    public static <T> Observable.Transformer<T, T> applyLog(SourceType sourceType) {
        if (!BuildConfig.DEBUG)
            return dataObservable -> dataObservable;
        else
            return dataObservable -> dataObservable
                    .doOnNext(object -> {
                        if (object != null && ((!(object instanceof List)) || ((List) object).size() > 0))
                            Timber.d("%s has the data you are looking for!", sourceType);
                        else
                            Timber.d("%s does not have any data.", sourceType);
                    });
    }

    public boolean isConnectionAvaible(ConnectivityStatus connectivityStatus) {
//        switch (connectivityStatus) {
//            case UNKNOWN:
//            case WIFI_CONNECTED:
//            case WIFI_CONNECTED_HAS_INTERNET:
//            case WIFI_CONNECTED_HAS_NO_INTERNET:
//            case MOBILE_CONNECTED:
//            c
        return true;
    }

}
