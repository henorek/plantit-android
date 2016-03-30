package com.henorek.plantit.data.net.api;

import com.henorek.plantit.data.net.TacticsEntityApi;
import java.util.List;
import retrofit.http.GET;
import rx.Observable;

public interface TacticsService {

  String TACTICS_REPOSITORY_ENDPOINT = "https://api.myjson.com/bins/";

  @GET("4wyn7") Observable<List<TacticsEntityApi>> getTactics();
}
