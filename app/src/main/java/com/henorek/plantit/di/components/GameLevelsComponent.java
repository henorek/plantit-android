package com.henorek.plantit.di.components;

import com.henorek.plantit.di.modules.GameLevelsModule;
import com.henorek.plantit.ui.presenters.SelectMapPresenter;
import com.henorek.plantit.ui.views.fragments.SelectMapViewFragment;
import com.henorek.plantit.ui.widgets.adapters.GameLevelsAdapter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = GameLevelsModule.class)
public interface GameLevelsComponent {

    void inject(SelectMapViewFragment fragment);

    SelectMapPresenter presenter();

    GameLevelsAdapter adapter();
}
