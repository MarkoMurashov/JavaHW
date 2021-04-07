package edu.dnu.fpm.pz;

import java.util.Collection;

public interface ICRUD<T> {
    Integer save(T entity) throws Exception;
    void saveAll(Collection<T> entities);

    T findById(Integer id);
    Collection<T> findAll();

    void update(T entity);

    void delete(Integer id);
}

