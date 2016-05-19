package com.henorek.plantit.di.components;

import com.henorek.plantit.di.modules.GameLevelsModule;
import com.henorek.plantit.ui.select_map_screen.SelectMapPresenter;
import com.henorek.plantit.ui.select_map_screen.SelectMapViewFragment;
import com.henorek.plantit.ui.select_map_screen.GameLevelsAdapter;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = GameLevelsModule.class) public interface GameLevelsComponent {

  void inject(SelectMapViewFragment fragment);

  SelectMapPresenter presenter();

  GameLevelsAdapter adapter();
}
