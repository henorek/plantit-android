package com.henorek.plantit.data.net.services;

import com.henorek.plantit.data.net.GameLevelApi;
import java.util.List;
import retrofit.http.GET;
import rx.Observable;

public interface GameLevelsService {

  String GAME_LEVELS_REPOSITORY_ENDPOINT = "https://api.myjson.com/bins/";

  @GET("4bnwf") Observable<List<GameLevelApi>> getGameLevels();
}
