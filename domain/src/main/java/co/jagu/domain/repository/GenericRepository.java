package co.jagu.domain.repository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface GenericRepository<T> {


    Flowable<List<T>> getAll();

    Flowable<T> getById(Long id);

    Flowable<T> insertOrUpdate(T entity);

    Completable deleteById(Long id);
}
