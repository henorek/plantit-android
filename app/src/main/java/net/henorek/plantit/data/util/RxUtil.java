package net.henorek.plantit.data.util;

import net.henorek.plantit.BuildConfig;
import net.henorek.plantit.data.enums.SourceType;

import java.util.List;

import rx.Observable;
import timber.log.Timber;

/**
 * Created by Michał Seroczyński (michal.seroczynski@audioteka.com) on 15.01.16.
 */
public class RxUtil {

    /**
     * Metoda ma za zadanie logować w konsoli ruch Rx'owy w zależności od źródła
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
}
