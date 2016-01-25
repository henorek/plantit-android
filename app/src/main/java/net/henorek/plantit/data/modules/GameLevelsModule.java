package net.henorek.plantit.data.modules;

import android.content.Context;

import com.squareup.picasso.Picasso;

import net.henorek.plantit.data.services.GameLevelsService;
import net.henorek.plantit.ui.widgets.controls.utils.ErrorMessageDeterminer;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

@Module
public class GameLevelsModule {

    private final Context context;

    public GameLevelsModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    Picasso providesPicasso() {
        return Picasso.with(context);
    }

    @Provides
    public GameLevelsService providesGameLevelsService() {
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(GameLevelsService.GAME_LEVELS_REPOSITORY_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return restAdapter.create(GameLevelsService.class);
    }

    @Provides
    public ErrorMessageDeterminer providesErrorMessageDeterminer() {
        return new ErrorMessageDeterminer();
    }
}
