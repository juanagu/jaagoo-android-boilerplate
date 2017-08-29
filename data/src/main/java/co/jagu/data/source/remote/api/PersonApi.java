package co.jagu.data.source.remote.api;

import co.jagu.data.entity.PersonEntity;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonApi {


    String URL = "person";

    @GET(URL + "/{id}")
    Flowable<PersonEntity> getPersonById(@Path("id") long id);
}
