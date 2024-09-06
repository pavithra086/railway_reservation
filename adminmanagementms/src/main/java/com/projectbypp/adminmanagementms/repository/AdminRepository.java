package com.projectbypp.adminmanagementms.repository;


import com.projectbypp.adminmanagementms.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface AdminRepository extends MongoRepository<Admin,Integer> {
    Admin findByUserName(String username);
}