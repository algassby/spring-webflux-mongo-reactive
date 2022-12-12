package com.barry.springmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.barry.springmongodb.model.Freelancer;

import reactor.core.publisher.Flux;

@Repository
public interface FreelancerRepository extends ReactiveMongoRepository<Freelancer, String> {

    @Query("{ 'skills': { $all: ?0 } }")
    Flux<Freelancer> findBySkillsAll(List<String> skills);

    Flux<Freelancer> findBySkillsIn(List<String> skills);

}