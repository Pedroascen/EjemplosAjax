package com.cds.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cds.crud.entity.Doctor;

@Repository
public interface IDoctorRepository extends CrudRepository<Doctor,Integer>{

}
