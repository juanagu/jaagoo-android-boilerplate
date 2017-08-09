package co.jagu.app.injection.component;

import co.jagu.app.injection.PerActivity;
import co.jagu.app.injection.module.BaseActivityModule;
import co.jagu.app.ui.base.BaseActivity;
import dagger.Subcomponent;

/**
 * This component inject dependencies to all Activities across the application
 */

@PerActivity
@Subcomponent(modules = BaseActivityModule.class)
public interface BaseActivityComponent {

    void inject(BaseActivity baseActivity);
}
