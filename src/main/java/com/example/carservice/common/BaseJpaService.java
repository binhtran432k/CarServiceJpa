package com.example.carservice.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseJpaService<E, ID, CD, D> {

	public abstract JpaRepository<E, ID> getDefaultRepository();

	public abstract E dtoToEntity(CD dto);

	public abstract D entityToDTO(E entity);

	public List<D> entitiesToDTOS(List<E> entities) {
		List<D> dtos = new ArrayList<>();
		entities.forEach(entity -> dtos.add(entityToDTO(entity)));
		return dtos;
	}

	public List<E> dtosToEntities(List<CD> dtos) {
		List<E> entities = new ArrayList<>();
		dtos.forEach(dto -> entities.add(dtoToEntity(dto)));
		return entities;
	}

	public D findById(ID id) {
		Optional<E> serviceOptional = getDefaultRepository().findById(id);
		if (!serviceOptional.isPresent()) {
			return null;
		}
		return entityToDTO(serviceOptional.get());
	}

	public List<D> findAll() {
		List<E> entities = getDefaultRepository().findAll();
		return entitiesToDTOS(entities);
	}

	public D save(CD dto) {
		return entityToDTO(getDefaultRepository().save(dtoToEntity(dto)));
	}

}
