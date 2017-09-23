package co.jagu.data.injection.component;

import javax.inject.Singleton;

import co.jagu.data.injection.module.TestBaseDataModule;
import dagger.Component;

@Singleton
@Component(modules = {TestBaseDataModule.class})
public interface TestBaseDataComponent extends BaseDataComponent {

}
