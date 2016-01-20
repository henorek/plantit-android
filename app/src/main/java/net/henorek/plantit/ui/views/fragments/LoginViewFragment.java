package net.henorek.plantit.ui.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.henorek.plantit.R;
import net.henorek.plantit.ui.base.BaseFragment;
import net.henorek.plantit.ui.presenters.LoginViewPresenter;

/**
 * Created by Jarek Jankowski.
 * jarosz1994@gmail.com
 */
public class LoginViewFragment extends BaseFragment<LoginViewPresenter> {

    @Override
    protected LoginViewPresenter createPresenter() {
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
