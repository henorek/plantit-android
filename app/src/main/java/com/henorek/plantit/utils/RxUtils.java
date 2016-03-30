package com.henorek.plantit.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxUtils {

  /**
   * This method is responsible for applying standard schedulers
   */
  public static <T> Observable.Transformer<T, T> applySchedulers() {
    return observable -> observable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
