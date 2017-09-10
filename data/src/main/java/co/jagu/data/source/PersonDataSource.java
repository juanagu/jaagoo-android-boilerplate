package co.jagu.data.source;


import co.jagu.data.entity.PersonEntity;

public interface PersonDataSource extends GenericDataSource<PersonEntity> {

    /*--
    Injection name
    --*/
    String INJECTION_LOCAL_NAME = "local_person_data_source";
    String INJECTION_REMOTE_NAME = "remote_person_data_source";
    String INJECTION_REPOSITORY_NAME = "repository_person_data_source";

}
