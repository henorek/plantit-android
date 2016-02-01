package net.henorek.plantit.data.net.api;

import android.support.annotation.NonNull;

import net.henorek.plantit.data.disk.entity.Tactic;
import net.henorek.plantit.data.net.helper.TransformHelper;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class TacticApiDataSource implements ITacticsApiDataSource {

    private final TacticsService primaryApiService;

    public TacticApiDataSource(TacticsService primaryApiService) {
        this.primaryApiService = primaryApiService;
    }

    @Override
    public Observable<List<Tactic>> getTactics(String title) {
        return primaryApiService.getTactics(title)
                .map(TransformHelper::apiArrayToModelArrayList)
                .map(chapters -> fillProductId(title, chapters));
    }

    @NonNull
    private ArrayList<Tactic> fillProductId(String title, ArrayList<Tactic> chapters) {
        //for (Chapter chapter : chapters)
        //    chapter.setProductId(productId);
        return chapters;
    }

}
