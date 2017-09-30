package co.jagu.data.entity.mapper;

import java.util.Collection;
import java.util.List;

/**
 * Mapper classed user to transform Entity to domain layer
 */
public interface EntityDataMapper<E, D> {

    E mapping(D domain);

    D transform(E entity);

    List<D> transform(Collection<E> entities);


}
