package com.cst8911.auth.repository;


import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.cst8911.auth.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CosmosRepository<User, String> {
    User findByEmail(String email);
}
