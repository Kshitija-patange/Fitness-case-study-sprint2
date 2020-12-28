package com.capgemini.fitness.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.fitness.entity.Admin;
/*
 * Admin Repository
 */
@Repository
public interface AdminDataDao 
				extends JpaRepository<Admin,Integer>{
}
