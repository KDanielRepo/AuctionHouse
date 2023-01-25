package pl.zsbd.kucd.interfaces;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T entity);
    void edit(T entity);
    void delete(T entity);
}
