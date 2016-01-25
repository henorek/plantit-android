package net.henorek.plantit.ui.base;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

public abstract class BasePresenter<V extends IBaseView> extends MvpBasePresenter<V> implements MvpPresenter<V> {
}
