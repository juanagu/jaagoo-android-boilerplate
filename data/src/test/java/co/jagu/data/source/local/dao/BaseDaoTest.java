package co.jagu.data.source.local.dao;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import javax.inject.Inject;

import co.jagu.data.ApplicationTestCase;
import co.jagu.data.injection.component.DaggerTestBaseDataComponent;
import co.jagu.data.injection.component.DaggerTestLocalDataSourceComponent;
import co.jagu.data.injection.component.TestLocalDataSourceComponent;
import co.jagu.data.injection.factory.ModuleFactory;

/**
 * class base for test dao with room
 */
public abstract class BaseDaoTest {

    /*--
    Dependencies
    --*/
    @Inject
    protected AppDatabase mDatabase;
    /*--
    Fields
    --*/

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =
            new InstantTaskExecutorRule();

    protected TestLocalDataSourceComponent testLocalDataSourceComponent;

    /*--
    Config
    --*/

    @Before
    public void setup() throws Exception {

        ModuleFactory moduleFactory = DaggerTestBaseDataComponent
                .builder()
                .build()
                .getModuleFactory();

        testLocalDataSourceComponent = DaggerTestLocalDataSourceComponent
                .builder()
                .databaseModule(moduleFactory
                        .createDatabaseModule(ApplicationTestCase.context(), ""))
                .build();


        testLocalDataSourceComponent.inject(this);
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }
}
