package com.henorek.plantit.ui.base.views;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.henorek.plantit.ui.base.activities.BaseActivity;

public interface IBaseView extends MvpView {

  BaseActivity getInstance();
}
