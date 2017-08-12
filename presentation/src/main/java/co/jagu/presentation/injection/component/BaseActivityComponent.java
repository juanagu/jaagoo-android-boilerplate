package co.jagu.presentation.injection.component;

import co.jagu.presentation.injection.PerActivity;
import co.jagu.presentation.injection.module.BaseActivityModule;
import co.jagu.presentation.ui.base.BaseActivity;
import dagger.Subcomponent;

/**
 * This component inject dependencies to all Activities across the application
 */

@PerActivity
@Subcomponent(modules = BaseActivityModule.class)
public interface BaseActivityComponent {

    void inject(BaseActivity baseActivity);
}
