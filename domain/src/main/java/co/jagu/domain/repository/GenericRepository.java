package co.jagu.domain.repository;

import java.util.List;

import io.reactivex.Flowable;

public interface GenericRepository<T> {


    Flowable<List<T>> getAll();

    Flowable<T> getById(Long id);

    void insertOrUpdate(T entity);

    void deleteAll();

    void deleteById(Long id);
}
