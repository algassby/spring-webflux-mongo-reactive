package com.barry.springmongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barry.springmongodb.model.Freelancer;
import com.barry.springmongodb.repository.FreelancerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FreelancerService {

    @Autowired
    private FreelancerRepository repository;

    public Flux<Freelancer> findBySkillsOne(final List<String> skills){
        return this.repository.findBySkillsIn(skills);
    }

    public Flux<Freelancer> findBySkillsAll(final List<String> skills){
        return this.repository.findBySkillsAll(skills);
    }

    public Mono<Freelancer> getPerson(final String id){
        return this.repository.findById(id);
    }

    public Mono<Freelancer> savePerson(final Freelancer person){
        return this.repository.save(person);
    }

    public Mono<Freelancer> updatePerson(final Freelancer person){
        return this.repository.findById(person.getId())
                    .map(p -> person)
                    .flatMap(this.repository::save);
    }

    public Mono<Void> deletePerson(final String id){
        return this.repository.deleteById(id);
    }

}