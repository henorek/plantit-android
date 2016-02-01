package net.henorek.plantit.ui.views.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;

import net.henorek.plantit.R;
import net.henorek.plantit.data.net.GameLevelApi;
import net.henorek.plantit.di.components.DaggerGameLevelsComponent;
import net.henorek.plantit.di.components.GameLevelsComponent;
import net.henorek.plantit.di.modules.GameLevelsModule;
import net.henorek.plantit.ui.interfaces.ISelectMapView;
import net.henorek.plantit.ui.presenters.SelectMapPresenter;
import net.henorek.plantit.ui.widgets.adapters.GameLevelsAdapter;
import net.henorek.plantit.ui.widgets.controls.utils.ErrorMessageDeterminer;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SelectMapViewFragment extends MvpLceViewStateFragment<SwipeRefreshLayout, List<GameLevelApi>, ISelectMapView, SelectMapPresenter>
        implements ISelectMapView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.fsmv_select_map_view)
    RecyclerView mapsView;

    @Inject
    ErrorMessageDeterminer errorMessageDeterminer;
    GameLevelsComponent gameLevelsComponent;
    GameLevelsAdapter adapter;

    protected void injectDependencies() {
        gameLevelsComponent = DaggerGameLevelsComponent.builder().gameLevelsModule(new GameLevelsModule(getActivity())).build();
        gameLevelsComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        injectDependencies();
        return inflater.inflate(R.layout.fragment_select_map_view, container, false);
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
        adapter = gameLevelsComponent.adapter();
        mapsView.setAdapter(adapter);
        mapsView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @NonNull
    @Override
    public LceViewState<List<GameLevelApi>, ISelectMapView> createViewState() {
        return new RetainingLceViewState<>();
    }

    @Override
    public List<GameLevelApi> getData() {
        return adapter.getGameLevelApis();
    }

    @Override
    public void setData(List<GameLevelApi> data) {
        adapter.setGameLevelApis(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return errorMessageDeterminer.getErrorMessage(e, pullToRefresh);
    }

    @NonNull
    @Override
    public SelectMapPresenter createPresenter() {
        return gameLevelsComponent.presenter();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadGameLevels(pullToRefresh);
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
