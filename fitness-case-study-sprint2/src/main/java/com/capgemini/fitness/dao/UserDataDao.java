package com.capgemini.fitness.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.fitness.entity.User;

/*
 * User Repository
 */
@Repository
public interface UserDataDao extends JpaRepository<User,Integer>{
}
