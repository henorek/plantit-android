package net.henorek.plantit.ui.widgets.components;

import net.henorek.plantit.data.modules.GameLevelsModule;
import net.henorek.plantit.ui.presenters.SelectMapPresenter;
import net.henorek.plantit.ui.views.fragments.SelectMapViewFragment;
import net.henorek.plantit.ui.widgets.adapters.GameLevelsAdapter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = GameLevelsModule.class)
public interface GameLevelsComponent {

    void inject(SelectMapViewFragment fragment);

    SelectMapPresenter presenter();

    GameLevelsAdapter adapter();
}
