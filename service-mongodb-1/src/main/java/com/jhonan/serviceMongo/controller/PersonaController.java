package com.jhonan.serviceMongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jhonan.serviceMongo.model.Persona;
import com.jhonan.serviceMongo.service.PersonaService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    
 // 1. metodo de ejemplo para verbo POST
    @PostMapping("/personas")
    public ResponseEntity<Void> save(@RequestBody Persona persona) {
        personaService.save(persona);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

 // 1. metodo de ejemplo para verbo GET
    @GetMapping("/personas")
    public List<Persona> findAll() {
        return personaService.findAll();
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<Persona> findById(@PathVariable String id) {
        Persona persona = personaService.findById(id).orElse(null);
        return persona != null ? ResponseEntity.ok(persona) : ResponseEntity.notFound().build();
    }

 // 4. metodo de ejemplo para verbo DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        personaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // 3. metodo de ejemplo para verbo UPDATE
    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody Persona persona) {
        personaService.save(persona);
        return ResponseEntity.noContent().build();
    }
    
 // Metodo de ejemplo para verbo PATCH
    @PatchMapping("/personas/{id}")
    public ResponseEntity<Void> updateData(@PathVariable String id, @RequestBody Persona updatedPersona) {
        Optional<Persona> optionalPersona = personaService.findById(id);
        if (optionalPersona.isPresent()) {
            Persona existingPersona = optionalPersona.get();
            
            // Actualizar solo los campos que se proporcionan en el JSON
            if (updatedPersona.getNombres() != null) {
                existingPersona.setNombres(updatedPersona.getNombres());
            }
            if (updatedPersona.getApellidos() != null) {
                existingPersona.setApellidos(updatedPersona.getApellidos());
            }
            if (updatedPersona.getEmail() != null) {
                existingPersona.setEmail(updatedPersona.getEmail());
            }
            if (updatedPersona.getEdad() != null) {
                existingPersona.setEdad(updatedPersona.getEdad());
            }
            
            personaService.save(existingPersona);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
 // 6. metodo de ejemplo para verbo HEAD
    @RequestMapping(value = "/personas/{id}", method = RequestMethod.HEAD)
    public ResponseEntity<?> handleHeadRequest(@PathVariable String id) {
        if (personaService.existsById(id)) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 7. metodo de ejemplo para verbo OPTIONS
    @RequestMapping(value = "/personas", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> optionsUpdate() {
        return ResponseEntity.ok().build();
    }
    
    
   
}
