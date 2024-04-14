package com.jhonan.serviceMongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonan.serviceMongo.model.Persona;
import com.jhonan.serviceMongo.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public void save(Persona persona) {
        personaRepository.save(persona);
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Optional<Persona> findById(String id) {
        return personaRepository.findById(id);
    }

    public void deleteById(String id) {
        personaRepository.deleteById(id);
    }
    
    public boolean existsById(String id) {
        return personaRepository.existsById(id);
    }
}
