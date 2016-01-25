package net.henorek.plantit.ui.base;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

public abstract class BasePresenter<VIEW extends IBaseView> extends MvpBasePresenter<VIEW> implements MvpPresenter<VIEW> {
}
