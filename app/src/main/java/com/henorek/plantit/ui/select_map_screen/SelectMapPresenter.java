package com.henorek.plantit.ui.select_map_screen;

import com.henorek.plantit.data.net.GameLevelApi;
import com.henorek.plantit.data.net.services.GameLevelsService;
import com.henorek.plantit.ui.base.presenters.BaseRxPresenter;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

public class SelectMapPresenter extends BaseRxPresenter<ISelectMapView, List<GameLevelApi>> {

  GameLevelsService gameLevelsService;

  @Inject public SelectMapPresenter(GameLevelsService gameLevelsService) {
    this.gameLevelsService = gameLevelsService;
  }

  public void loadGameLevels(boolean pullToRefresh) {
    Observable<List<GameLevelApi>> observable =
        gameLevelsService.getGameLevels().flatMap(gameLevels -> {
          Collections.shuffle(gameLevels);
          return Observable.just(gameLevels);
        });
    subscribe(observable, pullToRefresh);
  }
}
