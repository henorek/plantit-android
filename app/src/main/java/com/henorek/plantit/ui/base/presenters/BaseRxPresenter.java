package com.henorek.plantit.ui.base.presenters;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public abstract class BaseRxPresenter<VIEW extends MvpLceView<MODEL>, MODEL>
    extends MvpBasePresenter<VIEW> implements MvpPresenter<VIEW> {

  protected Subscriber<MODEL> subscriber;

  protected void unsubscribe() {
    if (subscriber != null && !subscriber.isUnsubscribed()) {
      subscriber.unsubscribe();
    }

    subscriber = null;
  }

  public void subscribe(Observable<MODEL> observable, final boolean pullToRefresh) {

    if (isViewAttached()) {
      getView().showLoading(pullToRefresh);
    }

    unsubscribe();

    subscriber = new Subscriber<MODEL>() {

      private boolean ptr = pullToRefresh;

      @Override public void onCompleted() {
        BaseRxPresenter.this.onCompleted();
      }

      @Override public void onError(Throwable e) {
        BaseRxPresenter.this.onError(e, ptr);
      }

      @Override public void onNext(MODEL MODEL) {
        BaseRxPresenter.this.onNext(MODEL);
      }
    };

    observable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }

  protected void onCompleted() {
    if (isViewAttached()) {
      getView().showContent();
    }
    unsubscribe();
  }

  protected void onError(Throwable e, boolean pullToRefresh) {
    if (isViewAttached()) {
      getView().showError(e, pullToRefresh);
    }
    unsubscribe();
  }

  protected void onNext(MODEL data) {
    if (isViewAttached()) {
      getView().setData(data);
    }
  }

  @Override public void detachView(boolean retainInstance) {
    super.detachView(retainInstance);
    if (!retainInstance) {
      unsubscribe();
    }
  }
}

