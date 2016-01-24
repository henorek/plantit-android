package net.henorek.plantit.ui.views.fragments;

import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import net.henorek.plantit.R;
import net.henorek.plantit.ui.base.BaseFragment;
import net.henorek.plantit.ui.base.BaseMvpFragment;
import net.henorek.plantit.ui.presenters.LoginViewPresenter;

/**
 * Created by Jarek Jankowski.
 * jarosz1994@gmail.com
 */
public class LoginViewFragment extends BaseMvpFragment {

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
