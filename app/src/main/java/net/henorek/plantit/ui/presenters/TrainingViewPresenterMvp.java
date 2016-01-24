package net.henorek.plantit.ui.presenters;

import net.henorek.plantit.data.models.TacticsEntity;
import net.henorek.plantit.data.services.TacticsService;
import net.henorek.plantit.ui.base.BaseMvpRxPresenter;
import net.henorek.plantit.ui.interfaces.ITrainingView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Jarek Jankowski on 2016-01-22.
 * jarosz1994@gmail.com
 */
public class TrainingViewPresenterMvp extends BaseMvpRxPresenter<ITrainingView, List<TacticsEntity>> {

    TacticsService tacticsService;

    @Inject
    public TrainingViewPresenterMvp(TacticsService tacticsService) {
        this.tacticsService = tacticsService;
    }

    public void loadTactics(boolean pullToRefresh) {
        Observable<List<TacticsEntity>> observable =
                tacticsService.getTactics()
                        .flatMap(repos -> {
                            Collections.shuffle(repos);
                            return Observable.just(repos);
                        });
        subscribe(observable, pullToRefresh);
    }
}
