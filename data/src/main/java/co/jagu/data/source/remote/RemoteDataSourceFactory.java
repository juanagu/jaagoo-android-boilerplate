package co.jagu.data.source.remote;


import co.jagu.data.injection.RemoteDataSource;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.remote.api.PersonApi;

public abstract class RemoteDataSourceFactory {

    /**
     * create a remote instance for {@link RemoteDataSource} {@link PersonDataSource} implementation
     *
     * @param personApi
     * @return
     */
    public static PersonDataSource createPersonDataSource(PersonApi personApi) {
        return new RemotePersonDataSource(personApi);
    }
}
