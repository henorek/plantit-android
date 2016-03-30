package com.henorek.plantit.ui.base.activities;

import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.delegate.ActivityMvpDelegateCallback;
import com.henorek.plantit.ui.base.presenters.BasePresenter;
import com.henorek.plantit.ui.base.views.IBaseView;
import com.henorek.plantit.ui.utils.ActivityConfig;
import timber.log.Timber;

public abstract class BaseActivity<VIEW extends IBaseView, PRESENTER extends BasePresenter<VIEW>>
    extends MvpActivity<VIEW, PRESENTER>
    implements ActivityMvpDelegateCallback<VIEW, PRESENTER>, IBaseView {

  private ActivityConfig activityConfig;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activityConfig = getConfig();

    setContentView();
    initLibraries();

    prepareView(savedInstanceState);
    addFragments();
  }

  protected abstract ActivityConfig getConfig();

  protected abstract void prepareView(Bundle savedInstanceState);

  protected abstract void addFragments();

  private void setContentView() {
    View root = View.inflate(this, activityConfig.layoutId, null);
    setContentView(root);
  }

  private void initLibraries() {
    ButterKnife.bind(this);
    Timber.plant(new Timber.DebugTree());
  }

  @Override public BaseActivity getInstance() {
    return this;
  }

  //@Override protected void attachBaseContext(Context newBase) {
  //  newBase = Flow.configure(newBase, this).install();
  //  super.attachBaseContext(newBase);
  //}
}