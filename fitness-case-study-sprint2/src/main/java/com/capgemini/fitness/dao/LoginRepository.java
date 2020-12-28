package com.capgemini.fitness.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.fitness.entity.User;
/*
 * Login Repository
 */
@Repository
public interface LoginRepository extends JpaRepository<User, Integer> {
}