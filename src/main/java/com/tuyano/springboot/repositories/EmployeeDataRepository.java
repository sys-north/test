package com.tuyano.springboot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuyano.springboot.EmployeeData;

@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeData, Long>{

	public Optional<EmployeeData>findById(long name);
	
}
