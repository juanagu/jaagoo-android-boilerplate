package co.jagu.app.injection.component;


import co.jagu.app.injection.ConfigPersistent;
import co.jagu.app.injection.module.BaseActivityModule;
import co.jagu.app.ui.base.BaseActivity;
import dagger.Component;

/**
 * A dagger component that will live during the lifecycle of an Activity but it won't
 * be destroy during configuration changes. Check {@link BaseActivity} to see how this components
 * survives configuration changes.
 * Use the {@link ConfigPersistent} scope to annotate dependencies that need to survive
 * configuration changes (for example Presenters).
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    BaseActivityComponent activityComponent(BaseActivityModule activityModule);
}
