package com.projetoteste.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoteste.userdept.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
