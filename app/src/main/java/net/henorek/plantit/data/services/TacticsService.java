package net.henorek.plantit.data.services;


import net.henorek.plantit.data.models.TacticsEntity;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Jarek Jankowski on 2016-01-21.
 * jarosz1994@gmail.com
 */
public interface TacticsService {

    String TACTICS_REPOSITORY_ENDPOINT = "https://api.myjson.com/bins/";

    @GET("4wyn7")
    Observable<List<TacticsEntity>> getTactics();
}
