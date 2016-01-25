package net.henorek.plantit.ui.views.fragments;

import android.os.Bundle;

import net.henorek.plantit.R;
import net.henorek.plantit.ui.base.BaseFragment;
import net.henorek.plantit.ui.presenters.LoginViewPresenter;

public class LoginViewFragment extends BaseFragment {

    @Override
    public LoginViewPresenter createPresenter() {
        return new LoginViewPresenter();
    }

    @Override
    protected void prepareView(Bundle savedInstanceState) {

    }

    @Override
    protected int getResourceId() {
        return R.layout.fragment_login_view;
    }

}
