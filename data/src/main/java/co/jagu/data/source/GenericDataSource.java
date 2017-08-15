package co.jagu.data.source;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @param <T>
 */
public interface GenericDataSource<T> {


    Flowable<List<T>> getAll();

    Flowable<T> getById(Long id);

    void insertOrUpdate(T entity);

    void deleteAll();

    void deleteById(Long id);
}
