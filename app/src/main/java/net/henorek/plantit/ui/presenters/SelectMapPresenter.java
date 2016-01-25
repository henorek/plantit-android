package net.henorek.plantit.ui.presenters;

import net.henorek.plantit.data.models.GameLevel;
import net.henorek.plantit.data.services.GameLevelsService;
import net.henorek.plantit.ui.base.presenters.BaseRxPresenter;
import net.henorek.plantit.ui.interfaces.ISelectMapView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class SelectMapPresenter extends BaseRxPresenter<ISelectMapView, List<GameLevel>> {

    GameLevelsService gameLevelsService;

    @Inject
    public SelectMapPresenter(GameLevelsService gameLevelsService) {
        this.gameLevelsService = gameLevelsService;
    }

    public void loadGameLevels(boolean pullToRefresh) {
        Observable<List<GameLevel>> observable =
                gameLevelsService.getGameLevels()
                        .flatMap(repos -> {
                            Collections.shuffle(repos);
                            return Observable.just(repos);
                        });
        subscribe(observable, pullToRefresh);
    }

}
