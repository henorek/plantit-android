package net.henorek.plantit.ui.presenters;

import net.henorek.plantit.data.models.TacticsEntityApi;
import net.henorek.plantit.data.services.TacticsService;
import net.henorek.plantit.ui.base.presenters.BaseRxPresenter;
import net.henorek.plantit.ui.interfaces.ITrainingView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class TrainingViewPresenter extends BaseRxPresenter<ITrainingView, List<TacticsEntityApi>> {

    TacticsService tacticsService;

    @Inject
    public TrainingViewPresenter(TacticsService tacticsService) {
        this.tacticsService = tacticsService;
    }

    public void loadTactics(boolean pullToRefresh) {
        Observable<List<TacticsEntityApi>> observable =
                tacticsService.getTactics()
                        .flatMap(repos -> {
                            Collections.shuffle(repos);
                            return Observable.just(repos);
                        });
        subscribe(observable, pullToRefresh);
    }
}
