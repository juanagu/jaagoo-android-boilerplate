package co.jagu.data.injection.module;


import javax.inject.Singleton;

import co.jagu.data.injection.factory.ModuleFactory;
import co.jagu.data.injection.factory.TestModuleFactory;
import dagger.Module;
import dagger.Provides;

@Module
public class TestBaseDataModule {

    @Provides
    @Singleton
    ModuleFactory provideModuleFactory() {
        return new TestModuleFactory();
    }
}
