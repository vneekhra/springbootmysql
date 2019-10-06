package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

}
