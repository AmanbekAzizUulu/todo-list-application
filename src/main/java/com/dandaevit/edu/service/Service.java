package com.dandaevit.edu.service;

import java.util.List;
import java.util.Optional;

public interface Service<T, R> {

    R save(T entity);
    void update(T entity);
    void delete(R id);

    Optional<T> findById(R id);
    List<T> findAll();
}
