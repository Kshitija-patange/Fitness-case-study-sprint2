package com.capgemini.fitness.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.fitness.entity.Trainer;
/*
 * Trainer Repository
 */
@Repository
public interface TrainerDataDao extends JpaRepository<Trainer,Integer>{

}
