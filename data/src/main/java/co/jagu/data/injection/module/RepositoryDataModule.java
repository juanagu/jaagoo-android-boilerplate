package co.jagu.data.injection.module;

import javax.inject.Singleton;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.entity.mapper.EntityDataMapper;
import co.jagu.data.entity.mapper.PersonEntityDataMapper;
import co.jagu.data.source.repository.RepositoryDataFactory;
import co.jagu.data.source.repository.RepositoryFactory;
import co.jagu.domain.Person;
import dagger.Module;
import dagger.Provides;

@Module(includes = {DatabaseModule.class, NetworkModule.class})
public class RepositoryDataModule {

    /**
     * provides of {@link EntityDataMapper}
     */
    @Provides
    @Singleton
    EntityDataMapper<PersonEntity, Person> providePersonEntityDataMapper() {
        return new PersonEntityDataMapper();
    }


    /**
     * provides of {@link RepositoryFactory}
     */
    @Provides
    @Singleton
    RepositoryFactory provideRepositoryFactory() {
        return new RepositoryDataFactory();
    }
}
