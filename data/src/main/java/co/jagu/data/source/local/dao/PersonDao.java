package co.jagu.data.source.local.dao;

import android.arch.persistence.room.Dao;

import co.jagu.data.entity.PersonEntity;
import io.reactivex.Flowable;

@Dao
public interface PersonDao {

    void insert(PersonEntity person);

    Flowable<PersonEntity> getPersonById(long id);
}
