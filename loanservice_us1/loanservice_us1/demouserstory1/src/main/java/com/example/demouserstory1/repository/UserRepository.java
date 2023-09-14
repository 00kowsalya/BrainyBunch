package com.example.demouserstory1.repository;

import com.example.demouserstory1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<UserEntity,Long> {
 /*   UserEntity findByUsername(String username);*/
    UserEntity findByEmail(String email);

}
