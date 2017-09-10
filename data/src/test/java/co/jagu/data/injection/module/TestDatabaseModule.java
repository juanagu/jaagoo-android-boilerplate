package co.jagu.data.injection.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import co.jagu.data.source.local.dao.AppDatabase;
import dagger.Module;

@Module
public class TestDatabaseModule extends DatabaseModule {


    public TestDatabaseModule(Context context) {
        super(context);
    }

    /*--
    Provides
    --*/

    @Override
    protected AppDatabase provideDatabase() {
        return Room.inMemoryDatabaseBuilder(context,
                AppDatabase.class)
                // allowing main thread queries, just for testing
                .allowMainThreadQueries()
                .build();
    }
}
