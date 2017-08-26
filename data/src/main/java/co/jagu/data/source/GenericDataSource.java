package co.jagu.data.source;

import io.reactivex.Flowable;

/**
 * @param <T>
 */
public interface GenericDataSource<T> {


    Flowable<T> getById(Long id);

    long insertOrUpdate(T entity);

   /* Flowable<List<T>> getAll();

    void deleteAll();

    void deleteById(Long id);*/
}
