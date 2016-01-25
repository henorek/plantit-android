package net.henorek.plantit.ui.views.fragments;

import android.os.Bundle;

import net.henorek.plantit.R;
import net.henorek.plantit.ui.base.fragments.BaseFragment;
import net.henorek.plantit.ui.interfaces.ILoginView;
import net.henorek.plantit.ui.presenters.LoginViewPresenter;

public class LoginViewFragment extends BaseFragment<ILoginView, LoginViewPresenter> implements ILoginView {

    @Override
    protected int getResourceId() {
        return R.layout.fragment_login_view;
    }

    @Override
    protected void prepareView(Bundle savedInstanceState) {

    }

    @Override
    public LoginViewPresenter createPresenter() {
        return new LoginViewPresenter();
    }
}
