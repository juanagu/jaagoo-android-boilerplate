package co.jagu.data.source.local.dao;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import javax.inject.Inject;

/**
 * class base for test dao with room
 */
public abstract class BaseDaoTest {

    @Inject
    protected AppDatabase mDatabase;


    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =
            new InstantTaskExecutorRule();

    /*--
    Config
    --*/

    @Before
    public void setup() throws Exception {
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }
}
