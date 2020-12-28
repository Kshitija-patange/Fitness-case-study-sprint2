package com.capgemini.fitness.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.fitness.dao.AdminDataDao;
import com.capgemini.fitness.entity.Admin;
import com.capgemini.fitness.exception.AdminException;

@Service
@Transactional
public class AdminServiceDataImpl implements AdminService{
	@Autowired
	private AdminDataDao adminDataDaoImpl;

	/*
	 * Add Admin method
	 */
	@Override
	public Integer addAdmin(Admin admin) throws AdminException {
		try {
			Admin p= 
					adminDataDaoImpl.save(admin);
			System.out.println(p);
			return 1;
		}catch(DataAccessException e) {
			throw new AdminException(e.getMessage(),e);
		}catch(Exception e) {
			throw new AdminException(e.getMessage(),e);
		}
	}

	/*
	 * Get Admin Details by passing Id
	 */
	@Override
	public Admin getAdminById(Integer adminId) throws AdminException {
		try {
			Optional<Admin> optional= 
					adminDataDaoImpl.findById(adminId);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}			
		}catch(DataAccessException e) {
			throw new AdminException(e.getMessage(),e);
		}catch(Exception e) {
			throw new AdminException(e.getMessage(),e);
		}
	}

	/*
	 * Update Admin Details
	 */
	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		try {
			Admin p= 
					adminDataDaoImpl.save(admin);
			return p;
		}catch(DataAccessException e) {
			throw new AdminException(e.getMessage(),e);
		}catch(Exception e) {
			throw new AdminException(e.getMessage(),e);
		}
	}
}

