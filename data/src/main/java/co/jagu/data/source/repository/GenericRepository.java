package co.jagu.data.source.repository;

import java.util.List;

import co.jagu.data.source.GenericDataSource;
import io.reactivex.Flowable;

/**
 * Created by juanagu on 13/8/17.
 */

public class GenericRepository<T> implements GenericDataSource<T> {


    @Override
    public Flowable<List<T>> getAll() {
        return null;
    }

    @Override
    public Flowable<T> getById(Long id) {
        return null;
    }

    @Override
    public void insertOrUpdate(T entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(Long id) {

    }
}
