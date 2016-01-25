package net.henorek.plantit.ui.base;

import android.os.Bundle;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.delegate.ActivityMvpDelegateCallback;

import net.henorek.plantit.ui.utils.ActivityConfig;

import butterknife.ButterKnife;
import timber.log.Timber;

public abstract class BaseActivity<V extends IBaseView, P extends BasePresenter<V>> extends MvpActivity<V, P> implements ActivityMvpDelegateCallback<V, P>, IBaseView {

    private ActivityConfig activityConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    @Override
    public BaseActivity getCurrentContext() {
        return this;
    }
}
