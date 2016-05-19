package com.henorek.plantit.ui.main_screen.login_screen;

import android.os.Bundle;
import com.henorek.plantit.R;
import com.henorek.plantit.ui.base.fragments.BaseFragment;

public class LoginViewFragment extends BaseFragment<ILoginView, LoginViewPresenter>
    implements ILoginView {

  @Override protected int getResourceId() {
    return R.layout.fragment_login_view;
  }

  @Override protected void prepareView(Bundle savedInstanceState) {

  }

  @Override public LoginViewPresenter createPresenter() {
    return new LoginViewPresenter();
  }
}
