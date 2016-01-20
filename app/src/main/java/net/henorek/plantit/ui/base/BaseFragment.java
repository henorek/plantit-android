package net.henorek.plantit.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Jarek Jankowski on 2016-01-20.
 * jarosz1994@gmail.com
 */
public abstract class BaseFragment<T extends BasePresenter<? extends IBaseView>> extends Fragment implements IBaseView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflateView(inflater, container);
        super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);
        prepareView(savedInstanceState); //kustomizacje widoku
        return view;
    }

    protected View inflateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(getResourceId(), container, false);
    }

    protected abstract int getResourceId();

    protected abstract T createPresenter();

    protected abstract void prepareView(Bundle savedInstanceState);
}
