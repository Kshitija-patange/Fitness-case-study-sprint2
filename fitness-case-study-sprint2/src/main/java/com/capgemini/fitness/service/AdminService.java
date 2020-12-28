package com.capgemini.fitness.service;
import com.capgemini.fitness.entity.Admin;
import com.capgemini.fitness.exception.AdminException;

public interface AdminService {
	public Integer addAdmin(Admin admin) throws  AdminException;
	public Admin getAdminById(Integer admin_id) throws  AdminException;
	public Admin updateAdmin(Admin admin) throws AdminException;

}
