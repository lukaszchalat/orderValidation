package de.lukaszchalat.orderValidation.request.repository;

import org.springframework.data.repository.CrudRepository;

import de.lukaszchalat.orderValidation.request.entity.ValidationRequest;

public interface ValidationRequestRepository extends CrudRepository<ValidationRequest, Long> {

}
