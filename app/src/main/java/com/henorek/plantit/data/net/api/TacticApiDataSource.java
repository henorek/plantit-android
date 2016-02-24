package com.henorek.plantit.data.net.api;

import android.support.annotation.NonNull;

import com.henorek.plantit.data.disk.entity.Tactic;
import com.henorek.plantit.data.net.helper.TransformHelper;

import java.util.List;

import rx.Observable;

public class TacticApiDataSource implements ITacticsApiDataSource {

    private final TacticsService primaryApiService;

    public TacticApiDataSource(TacticsService primaryApiService) {
        this.primaryApiService = primaryApiService;
    }

    @Override
    public Observable<List<Tactic>> getTactics(String title) {
        return primaryApiService.getTactics()
//                .map(TransformHelper::apiArrayToModelArrayList);
                .map(chapters -> fillProductId(title, chapters));
    }

    @NonNull
    private List<Tactic> fillProductId(String title, List<Tactic> chapters) {
        //for (Chapter chapter : chapters)
        //    chapter.setProductId(productId);
        return chapters;
    }

}
