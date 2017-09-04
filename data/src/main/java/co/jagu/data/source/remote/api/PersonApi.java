package co.jagu.data.source.remote.api;

import co.jagu.data.entity.PersonEntity;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PersonApi {


    String URL = "person";

    @GET(URL + "/{id}")
    Flowable<PersonEntity> getPersonById(@Path("id") long id);

    @FormUrlEncoded
    @POST(URL)
    Flowable<PersonEntity> insert(@Body PersonEntity personEntity);

    @PUT(URL + "/{id}")
    Flowable<PersonEntity> update(@Path("id") long id,
                                  @Body PersonEntity personEntity);
}
