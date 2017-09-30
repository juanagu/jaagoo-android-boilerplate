package co.jagu.data.source;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @param <T>
 */
public interface GenericDataSource<T> {


    Flowable<T> getById(Long id);

    Flowable<T> insertOrUpdate(T entity);

    Flowable<List<T>> getAll();

    void deleteById(long id);
}
