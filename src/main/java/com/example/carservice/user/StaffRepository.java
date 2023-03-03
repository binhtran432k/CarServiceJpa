package com.example.carservice.user;

import java.util.Collection;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

	Set<Staff> findByIdIn(Collection<Integer> ids);

}
