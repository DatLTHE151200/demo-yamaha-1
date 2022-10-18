package com.example.demoyamaha1.service;

import java.util.Optional;

public interface BaseService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
