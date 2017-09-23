package co.jagu.data.source.remote.api.factory;


import com.google.gson.JsonObject;

import co.jagu.data.source.factory.CommonPersonFakeFactory;

/**
 * create a fake response for person
 */
public abstract class RemotePersonFakeFactory {

    /*--
    Get Person
    --*/

    /**
     * create a fake json person with id
     *
     * @param id
     * @return
     */
    public static String createResponseBodyGetPersonById(long id) {

        JsonObject jsonPerson = new JsonObject();

        jsonPerson.addProperty("id", id);
        jsonPerson.addProperty("first_name", CommonPersonFakeFactory.randomFirstName());
        jsonPerson.addProperty("last_name", CommonPersonFakeFactory.randomLastName());

        return jsonPerson.toString();

    }

}
