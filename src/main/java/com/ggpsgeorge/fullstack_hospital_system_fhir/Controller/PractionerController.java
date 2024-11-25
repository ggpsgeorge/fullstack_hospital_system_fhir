package com.ggpsgeorge.fullstack_hospital_system_fhir.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggpsgeorge.fullstack_hospital_system_fhir.Models.ResourceType.Practioner;
import com.ggpsgeorge.fullstack_hospital_system_fhir.Repository.PractionerRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/practioner/v1")
public class PractionerController {
    
    @Autowired
    PractionerRepository practionerRepository;

    @PostMapping("/")
    public ResponseEntity<List<Practioner>> addPractioners(@RequestBody List<Practioner> practioners) {
        return ResponseEntity.accepted().body(practionerRepository.saveAll(practioners)); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Practioner> getPractioner(@PathVariable String id){
        try {
            Practioner practioner = practionerRepository.findById(id).orElseThrow();
            return ResponseEntity.ok().body(practioner);
        } catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Practioner> updatePractioner(@PathVariable String id, @RequestBody Practioner newPractioner) {
        try {
            practionerRepository.findById(id).orElseThrow();
            Practioner practioner = practionerRepository.save(newPractioner);
            return ResponseEntity.accepted().body(practioner);
            
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePractioner(@PathVariable String id) {
        try {
            practionerRepository.findById(id).orElseThrow();
            practionerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
