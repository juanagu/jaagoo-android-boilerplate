package co.jagu.data.injection.component;

import javax.inject.Singleton;

import co.jagu.data.injection.factory.ModuleFactory;
import co.jagu.data.injection.module.BaseDataModule;
import dagger.Component;

@Singleton
@Component(modules = {BaseDataModule.class})
public interface BaseDataComponent {

    ModuleFactory getModuleFactory();
}
