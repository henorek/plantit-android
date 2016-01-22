package net.henorek.plantit.ui.widgets.components;

import net.henorek.plantit.data.modules.TacticsModule;
import net.henorek.plantit.ui.presenters.TrainingViewPresenter;
import net.henorek.plantit.ui.views.fragments.TrainingViewFragment;
import net.henorek.plantit.ui.widgets.adapters.TacticsAdapter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jarek Jankowski on 2016-01-22.
 * jarosz1994@gmail.com
 */

@Singleton
@Component(modules = TacticsModule.class)
public interface TacticsComponent {

    void inject(TrainingViewFragment fragment);

    TrainingViewPresenter presenter();

    TacticsAdapter adapter();
}
