package net.henorek.plantit.ui.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import net.henorek.plantit.ui.utils.ActivityConfig;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by Jarek Jankowski on 2016-01-18.
 */
public abstract class BaseActivity<T extends BasePresenter<? extends IBaseView>> extends FragmentActivity implements IBaseView {

    protected T presenter;
    private ActivityConfig activityConfig;

    @Override
    final protected void onCreate(Bundle savedInstanceState) {
        activityConfig = getConfig();

        super.onCreate(savedInstanceState);

        presenter = createPresenter();

        setContentView();
        initLibraries();

        prepareView(savedInstanceState);
        addFragments();
    }

    protected abstract ActivityConfig getConfig();

    protected abstract T createPresenter();

    protected abstract void prepareView(Bundle savedInstanceState);

    protected abstract void addFragments();

    private void setContentView(){
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

    @Override
    public T getPresenter() {
        return presenter;
    }
}
