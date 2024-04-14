package com.jhonan.serviceMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jhonan.serviceMongo.model.Persona;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, String> {

}
