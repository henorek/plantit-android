package net.henorek.plantit.ui.base;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jarek Jankowski on 2016-01-22.
 * jarosz1994@gmail.com
 */

public abstract class BaseMvpRxPresenter<V extends MvpLceView<M>, M>
        extends MvpBasePresenter<V>
        implements MvpPresenter<V> {

    protected Subscriber<M> subscriber;

    protected void unsubscribe() {
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }

        subscriber = null;
    }

    public void subscribe(Observable<M> observable, final boolean pullToRefresh) {

        if (isViewAttached()) {
            getView().showLoading(pullToRefresh);
        }

        unsubscribe();

        subscriber = new Subscriber<M>() {

            private boolean ptr = pullToRefresh;

            @Override
            public void onCompleted() {
                BaseMvpRxPresenter.this.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                BaseMvpRxPresenter.this.onError(e, ptr);
            }

            @Override
            public void onNext(M m) {
                BaseMvpRxPresenter.this.onNext(m);
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

    protected void onNext(M data) {
        if (isViewAttached()) {
            getView().setData(data);
        }
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance) {
            unsubscribe();
        }
    }
}

