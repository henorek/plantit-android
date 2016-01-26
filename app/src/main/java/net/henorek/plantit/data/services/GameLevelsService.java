package net.henorek.plantit.data.services;

import net.henorek.plantit.data.models.GameLevelApi;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

public interface GameLevelsService {

    String GAME_LEVELS_REPOSITORY_ENDPOINT = "https://api.myjson.com/bins/";

    @GET("4bnwf")
    Observable<List<GameLevelApi>> getGameLevels();
}
