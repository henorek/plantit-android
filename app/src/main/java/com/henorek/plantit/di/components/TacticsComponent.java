package com.henorek.plantit.di.components;

import com.henorek.plantit.di.modules.TacticsModule;
import com.henorek.plantit.ui.presenters.TrainingViewPresenter;
import com.henorek.plantit.ui.views.fragments.TrainingViewFragment;
import com.henorek.plantit.ui.widgets.adapters.TacticsAdapter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TacticsModule.class)
public interface TacticsComponent {

    void inject(TrainingViewFragment fragment);

    TrainingViewPresenter presenter();

    TacticsAdapter adapter();
}
