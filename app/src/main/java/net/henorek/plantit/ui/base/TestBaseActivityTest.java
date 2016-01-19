package net.henorek.plantit.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import net.henorek.plantit.ui.utils.ActivityConfig;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by Jarek Jankowski on 2016-01-19.
 * jarosz1994@gmail.com
 */
public abstract class TestBaseActivityTest extends MvpActivity<TestIBaseView, TestBasePresenterTest> implements TestIBaseView {

    private ActivityConfig activityConfig;

    @NonNull
    @Override
    public TestBasePresenterTest createPresenter() {
        return new TestBasePresenterTest();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        ButterKnife.bind(this);

        Timber.plant(new Timber.DebugTree());

        prepareView(savedInstanceState);
    }

    protected abstract void prepareView(Bundle savedInstanceState);

    protected abstract ActivityConfig getConfig();

    private void setContentView(){
        View root = View.inflate(this, activityConfig.layoutId, null);
        setContentView(root);
    }
}
