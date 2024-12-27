package com.example.todo_backend.service;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractInMemoryService<T, ID> implements CrudService<T, ID> {
    protected List<T> storage = new ArrayList<>();

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public T findById(ID id) {
        return storage.stream()
                .filter(entity -> matchesId(entity, id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    @Override
    public T save(T entity) {
        storage.add(entity);
        return entity;
    }

    @Override
    public void deleteById(ID id) {
        storage.removeIf(entity -> matchesId(entity, id));
    }

    protected abstract boolean matchesId(T entity, ID id);
}