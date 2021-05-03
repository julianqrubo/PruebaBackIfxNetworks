package com.backend.ifxnetworks.service;

import java.util.List;
import java.util.Optional;

public interface SuperCrud<T> {

	Optional<T> getById(Long id);

	List<T> getAll();

	Long create(T entity);

	void update(Long id, T entity);

	void delete(Long id);

}
