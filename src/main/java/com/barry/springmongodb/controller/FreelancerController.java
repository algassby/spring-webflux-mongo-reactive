package com.barry.springmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barry.springmongodb.model.Freelancer;
import com.barry.springmongodb.service.FreelancerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FreelancerController {

    @Autowired
    private FreelancerService freelancerService;

    @GetMapping("/person/skills-one/{skills}")
    public Flux<Freelancer> findBySkills(@PathVariable List<String> skills){
        return this.freelancerService.findBySkillsOne(skills);
    }

    @GetMapping("/person/skills-all/{skills}")
    public Flux<Freelancer> findByAllSkills(@PathVariable List<String> skills){
        return this.freelancerService.findBySkillsAll(skills);
    }

    @GetMapping("/person/{id}")
    public Mono<Freelancer> getPerson(@PathVariable String id){
        return this.freelancerService.getPerson(id);
    }

    @PostMapping("/person")
    public Mono<Freelancer> createPerson(@RequestBody Freelancer person){
        return this.freelancerService.savePerson(person);
    }

    @PutMapping("/person")
    public Mono<Freelancer> updatePerson(@RequestBody Freelancer person){
        return this.freelancerService.updatePerson(person);
    }
    
    @DeleteMapping("/person/{id}")
    public Mono<Void> deletePerson(@PathVariable String id){
        return this.freelancerService.deletePerson(id);
    }

}