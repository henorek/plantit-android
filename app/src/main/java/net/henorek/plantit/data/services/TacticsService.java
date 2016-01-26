package net.henorek.plantit.data.services;


import net.henorek.plantit.data.models.TacticsEntityApi;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

public interface TacticsService {

    String TACTICS_REPOSITORY_ENDPOINT = "https://api.myjson.com/bins/";

    @GET("4wyn7")
    Observable<List<TacticsEntityApi>> getTactics();
}
