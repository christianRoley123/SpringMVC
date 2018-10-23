package com.springmvc.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.AdminDAO;
import com.springmvc.model.Admin;

@Service
public class AdminService {
	@Autowired
	private AdminDAO adminDAO;
	
	public boolean save(Admin admin) {
		
		return adminDAO.save(admin);
	}

	public List<Admin> findAll() {
		
		
		return adminDAO.findAll();
	}

	public Admin findById(int id) {
		
		
		return adminDAO.findById(id);
	}

	public List<Admin> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int idAd) {
		// TODO Auto-generated method stub
		return false;
	}

	public int[] saveAll(List<Admin> admins) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
}
