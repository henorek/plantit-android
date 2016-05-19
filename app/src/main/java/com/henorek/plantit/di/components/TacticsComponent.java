package com.henorek.plantit.di.components;

import com.henorek.plantit.di.modules.TacticsModule;
import com.henorek.plantit.ui.main_screen.activities_screen.training_screen.TrainingViewPresenter;
import com.henorek.plantit.ui.main_screen.activities_screen.training_screen.TrainingViewFragment;
import com.henorek.plantit.ui.widgets.adapters.TacticsAdapter;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = TacticsModule.class) public interface TacticsComponent {

  void inject(TrainingViewFragment fragment);

  TrainingViewPresenter presenter();

  TacticsAdapter adapter();
}
