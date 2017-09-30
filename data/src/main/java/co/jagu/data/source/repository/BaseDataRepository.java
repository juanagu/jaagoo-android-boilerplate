package co.jagu.data.source.repository;


import co.jagu.data.entity.mapper.EntityDataMapper;

public abstract class BaseDataRepository<E, D> {

    /*--
    Dependency
    --*/
    protected EntityDataMapper<E, D> entityDataMapper;

    public BaseDataRepository(EntityDataMapper entityDataMapper) {
        this.entityDataMapper = entityDataMapper;
    }
}
