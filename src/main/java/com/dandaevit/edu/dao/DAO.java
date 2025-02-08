package com.dandaevit.edu.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T, R> {

    // Метод для сохранения сущности
    void save(T entity);

    // Метод для обновления сущности
    void update(T entity);

    // Метод для удаления сущности по идентификатору
    void delete(R id);

    // Метод для получения сущности по идентификатору
    Optional<T> findById(R id);

    // Метод для получения всех сущностей
    List<T> findAll();
}
