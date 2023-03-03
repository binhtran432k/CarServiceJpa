package com.example.carservice.service;

import java.util.Collection;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceModelRepository extends JpaRepository<ServiceModel, Integer> {

	Set<ServiceModel> findByIdIn(Collection<Integer> ids);

}
