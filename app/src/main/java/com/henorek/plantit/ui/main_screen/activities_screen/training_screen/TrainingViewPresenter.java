package com.henorek.plantit.ui.main_screen.activities_screen.training_screen;

import com.henorek.plantit.data.net.TacticsEntityApi;
import com.henorek.plantit.data.net.api.TacticsService;
import com.henorek.plantit.ui.base.presenters.BaseRxPresenter;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

public class TrainingViewPresenter extends BaseRxPresenter<ITrainingView, List<TacticsEntityApi>> {

  TacticsService tacticsService;

  @Inject public TrainingViewPresenter(TacticsService tacticsService) {
    this.tacticsService = tacticsService;
  }

  public void loadTactics(boolean pullToRefresh) {
    Observable<List<TacticsEntityApi>> observable = tacticsService.getTactics().flatMap(repos -> {
      Collections.shuffle(repos);
      return Observable.just(repos);
    });
    subscribe(observable, pullToRefresh);
  }
}
