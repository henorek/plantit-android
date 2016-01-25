package net.henorek.plantit.ui.widgets.components;

import net.henorek.plantit.data.modules.TacticsModule;
import net.henorek.plantit.ui.presenters.TrainingViewPresenter;
import net.henorek.plantit.ui.views.fragments.TrainingViewFragment;
import net.henorek.plantit.ui.widgets.adapters.TacticsAdapter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TacticsModule.class)
public interface TacticsComponent {

    void inject(TrainingViewFragment fragment);

    TrainingViewPresenter presenter();

    TacticsAdapter adapter();
}
