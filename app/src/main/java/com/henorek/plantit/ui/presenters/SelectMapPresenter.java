package com.henorek.plantit.ui.presenters;

import com.henorek.plantit.data.net.GameLevelApi;
import com.henorek.plantit.data.net.services.GameLevelsService;
import com.henorek.plantit.ui.base.presenters.BaseRxPresenter;
import com.henorek.plantit.ui.interfaces.ISelectMapView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class SelectMapPresenter extends BaseRxPresenter<ISelectMapView, List<GameLevelApi>> {

    GameLevelsService gameLevelsService;

    @Inject
    public SelectMapPresenter(GameLevelsService gameLevelsService) {
        this.gameLevelsService = gameLevelsService;
    }

    public void loadGameLevels(boolean pullToRefresh) {
        Observable<List<GameLevelApi>> observable =
                gameLevelsService.getGameLevels()
                        .flatMap(gameLevels -> {
                            Collections.shuffle(gameLevels);
                            return Observable.just(gameLevels);
                        });
        subscribe(observable, pullToRefresh);
    }
//
//    private void cacheGameLevels() throws SQLException, AudiotekaException {
//        promotedCollections = BLLFactory.getInstance().getStaticService().getPromotedCollections();
//        if (promotedCollections != null) {
//            for(PromotedCollection collection : promotedCollections){
//                collection.setUpdateTime(new Date());
//                _dbHelper.getPromotedCollectionDao().createOrUpdate(collection);
//            }
//        }
//    }

}