package com.henorek.plantit.ui.views.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;
import com.henorek.plantit.R;
import com.henorek.plantit.data.net.TacticsEntityApi;
import com.henorek.plantit.di.components.DaggerTacticsComponent;
import com.henorek.plantit.di.components.TacticsComponent;
import com.henorek.plantit.di.modules.TacticsModule;
import com.henorek.plantit.ui.interfaces.ITrainingView;
import com.henorek.plantit.ui.presenters.TrainingViewPresenter;
import com.henorek.plantit.ui.widgets.adapters.TacticsAdapter;
import com.henorek.plantit.ui.widgets.controls.utils.ErrorMessageDeterminer;
import java.util.List;
import javax.inject.Inject;

public class TrainingViewFragment extends
    MvpLceViewStateFragment<SwipeRefreshLayout, List<TacticsEntityApi>, ITrainingView, TrainingViewPresenter>
    implements ITrainingView, SwipeRefreshLayout.OnRefreshListener {

  @Bind(R.id.recyclerView) RecyclerView recyclerView;

  @Inject ErrorMessageDeterminer errorMessageDeterminer;
  TacticsComponent tacticsComponent;
  TacticsAdapter adapter;

  protected void injectDependencies() {
    tacticsComponent =
        DaggerTacticsComponent.builder().tacticsModule(new TacticsModule(getActivity())).build();
    tacticsComponent.inject(this);
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    injectDependencies();
    return inflater.inflate(R.layout.fragment_training_view, container, false);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    adapter = tacticsComponent.adapter();
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }

  @NonNull @Override public LceViewState<List<TacticsEntityApi>, ITrainingView> createViewState() {
    return new RetainingLceViewState<>();
  }

  @Override public List<TacticsEntityApi> getData() {
    return adapter.getTactics();
  }

  @Override public void setData(List<TacticsEntityApi> data) {
    adapter.setTactics(data);
    adapter.notifyDataSetChanged();
  }

  @Override protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
    return errorMessageDeterminer.getErrorMessage(e, pullToRefresh);
  }

  @NonNull @Override public TrainingViewPresenter createPresenter() {
    return tacticsComponent.presenter();
  }

  @Override public void loadData(boolean pullToRefresh) {
    presenter.loadTactics(pullToRefresh);
  }

  @Override public void onRefresh() {
    loadData(true);
  }

  @Override public void showError(Throwable e, boolean pullToRefresh) {
    super.showError(e, pullToRefresh);
    contentView.setRefreshing(false);
    e.printStackTrace();
  }

  @Override public void showContent() {
    super.showContent();
    contentView.setRefreshing(false);
  }

  @Override public void showLoading(boolean pullToRefresh) {
    super.showLoading(pullToRefresh);
    if (pullToRefresh && !contentView.isRefreshing()) {
      contentView.post(() -> contentView.setRefreshing(true));
    }
  }
}
