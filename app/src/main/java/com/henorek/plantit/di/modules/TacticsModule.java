package com.henorek.plantit.di.modules;

import android.content.Context;

import com.henorek.plantit.data.net.api.TacticsService;
import com.squareup.picasso.Picasso;

import com.henorek.plantit.ui.widgets.controls.utils.ErrorMessageDeterminer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

@Module
@Singleton
public class TacticsModule {

    private final Context context;

    public TacticsModule(Context context) {
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
    public TacticsService providesTacticsService() {
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(TacticsService.TACTICS_REPOSITORY_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return restAdapter.create(TacticsService.class);
    }

    @Provides
    public ErrorMessageDeterminer providesErrorMessageDeterminer() {
        return new ErrorMessageDeterminer();
    }

}
