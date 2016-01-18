package net.henorek.plantit.ui.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import net.henorek.plantit.ui.utils.ActivityConfig;

import butterknife.ButterKnife;

/**
 * Created by Jarek Jankowski on 2016-01-18.
 */
public abstract class BasePlantitActivity<T extends BasePlantitPresenter<? extends IBasePlantitView>> extends FragmentActivity implements IBasePlantitView {

    private ActivityConfig activityConfig;

    @Override
    final protected void onCreate(Bundle savedInstanceState) {
        activityConfig = getConfig();

        super.onCreate(savedInstanceState);
        setContentView();
        ButterKnife.bind(this);

        prepareView(savedInstanceState);
    }

    protected abstract ActivityConfig getConfig();

    protected abstract T createPresenter();

    protected abstract void prepareView(Bundle savedInstanceState);

    protected abstract void addFragments();

    private void setContentView(){
        View root = View.inflate(this, activityConfig.layoutId, null);
        setContentView(root);
    }
}
