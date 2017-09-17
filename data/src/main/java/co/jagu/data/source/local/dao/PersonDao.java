package co.jagu.data.source.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import javax.inject.Singleton;

import co.jagu.data.entity.PersonEntity;
import io.reactivex.Flowable;

@Dao
@Singleton
public interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertOrUpdate(PersonEntity person);

    @Query("SELECT * FROM persons where id = :id")
    Flowable<PersonEntity> getPersonById(long id);
}
