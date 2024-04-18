package com.jhonan.serviceMongo.repository;

import com.jhonan.serviceMongo.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public PersonaRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(Persona persona) {
        mongoTemplate.save(persona);
    }

    public List<Persona> findAll() {
        return mongoTemplate.findAll(Persona.class);
    }

    public Optional<Persona> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Persona.class));
    }

    public void deleteById(String id) {
        mongoTemplate.remove(findById(id).orElse(null));
    }

    public boolean existsById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Persona.class) != null;
    }
}
