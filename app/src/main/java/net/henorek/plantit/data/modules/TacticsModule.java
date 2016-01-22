package net.henorek.plantit.data.modules;

import android.content.Context;

import com.squareup.picasso.Picasso;

import net.henorek.plantit.data.services.TacticsService;
import net.henorek.plantit.ui.widgets.controls.ErrorMessageDeterminer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Jarek Jankowski on 2016-01-22.
 * jarosz1994@gmail.com
 */
@Module
public class TacticsModule {

    private Context context;

    public TacticsModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    Picasso providesPicasso() {
        return Picasso.with(context);
    }

    @Provides
    @Singleton
    public TacticsService providesTacticsService() {
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(TacticsService.TACTICS_REPOSITORY_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return restAdapter.create(TacticsService.class);
    }

    @Provides
    @Singleton
    public ErrorMessageDeterminer providesErrorMessageDeterminer() {
        return new ErrorMessageDeterminer();
    }

}
