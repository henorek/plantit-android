package net.henorek.plantit.ui.base.presenters;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import net.henorek.plantit.ui.base.views.IBaseView;

public abstract class BasePresenter<VIEW extends IBaseView> extends MvpBasePresenter<VIEW> implements MvpPresenter<VIEW> {
}
