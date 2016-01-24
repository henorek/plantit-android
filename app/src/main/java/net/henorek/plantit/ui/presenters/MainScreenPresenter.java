package net.henorek.plantit.ui.presenters;

import android.support.annotation.Nullable;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import net.henorek.plantit.ui.base.BaseMvpPresenter;
import net.henorek.plantit.ui.base.BaseMvpView;
import net.henorek.plantit.ui.base.BasePresenter;
import net.henorek.plantit.ui.interfaces.IMainScreenView;

/**
 * Created by Jarek Jankowski on 2016-01-18.
 */
public class MainScreenPresenter extends BaseMvpPresenter {


//    @Override
//    public void loadData(boolean refresh) {
//
//    }


    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }

    @Override
    public boolean isViewAttached() {
        return super.isViewAttached();
    }
//
//    @Nullable
//    @Override
//    public MvpView getView() {
//        return super.getView();
//    }
//
//    @Override
//    public void attachView(MvpView view) {
//        super.attachView(view);
//    }


    @Nullable
    @Override
    public BaseMvpView getView() {
        return super.getView();
    }

    @Override
    public void attachView(BaseMvpView view) {
        super.attachView(view);
    }

    public MainScreenPresenter() {
        super();
    }
}
