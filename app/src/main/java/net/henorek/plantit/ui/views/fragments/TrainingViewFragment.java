package net.henorek.plantit.ui.views.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;

import net.henorek.plantit.R;
import net.henorek.plantit.data.models.TacticsEntity;
import net.henorek.plantit.data.modules.TacticsModule;
import net.henorek.plantit.ui.interfaces.ITrainingView;
import net.henorek.plantit.ui.presenters.TrainingViewPresenter;
import net.henorek.plantit.ui.widgets.adapters.TacticsAdapter;
import net.henorek.plantit.ui.widgets.components.DaggerTacticsComponent;
import net.henorek.plantit.ui.widgets.components.TacticsComponent;
import net.henorek.plantit.ui.widgets.controls.ErrorMessageDeterminer;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

public class TrainingViewFragment extends MvpLceViewStateFragment<SwipeRefreshLayout, List<TacticsEntity>, ITrainingView, TrainingViewPresenter>
        implements ITrainingView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Inject
    ErrorMessageDeterminer errorMessageDeterminer;
    TacticsComponent tacticsComponent;
    TacticsAdapter adapter;

    protected void injectDependencies() {
        tacticsComponent = DaggerTacticsComponent.builder().tacticsModule(new TacticsModule(getActivity())).build();
        tacticsComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        injectDependencies();
        return inflater.inflate(R.layout.fragment_training_view, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        adapter = tacticsComponent.adapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @NonNull
    @Override
    public LceViewState<List<TacticsEntity>, ITrainingView> createViewState() {
        return new RetainingLceViewState<>();
    }

    @Override
    public List<TacticsEntity> getData() {
        return adapter.getTactics();
    }

    @Override
    public void setData(List<TacticsEntity> data) {
        adapter.setTactics(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        Timber.v(e, "O co chodzi?");
        return errorMessageDeterminer.getErrorMessage(e, pullToRefresh);
    }

    @NonNull
    @Override
    public TrainingViewPresenter createPresenter() {
        return tacticsComponent.presenter();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadTactics(pullToRefresh);
    }

    @Override
    public void onRefresh() {
        loadData(true);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
        contentView.setRefreshing(false);
        e.printStackTrace();
    }

    @Override
    public void showContent() {
        super.showContent();
        contentView.setRefreshing(false);
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);
        if (pullToRefresh && !contentView.isRefreshing()) {
            contentView.post(() -> contentView.setRefreshing(true));
        }
    }
}
