package co.jagu.data.source.local.dao;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import co.jagu.data.ApplicationTestCase;

/**
 * class base for test dao with room
 */
public abstract class BaseDaoTest {

    protected AppDatabase mDatabase;


    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =
            new InstantTaskExecutorRule();

    @Before
    public void initDb() throws Exception {
        // using an in-memory database because the information stored here disappears when the
        // process is killed
        mDatabase = Room.inMemoryDatabaseBuilder(ApplicationTestCase.context(),
                AppDatabase.class)
                // allowing main thread queries, just for testing
                .allowMainThreadQueries()
                .build();
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }
}
