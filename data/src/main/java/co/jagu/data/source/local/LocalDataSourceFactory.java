package co.jagu.data.source.local;

import co.jagu.data.injection.LocalDataSource;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.local.dao.PersonDao;

public abstract class LocalDataSourceFactory {

    /**
     * create a local instance for {@link LocalDataSource} {@link PersonDataSource} implementation
     *
     * @param personDao
     * @return
     */
    public static PersonDataSource createPersonDataSource(PersonDao personDao) {
        return new LocalPersonDataSource(personDao);
    }
}
