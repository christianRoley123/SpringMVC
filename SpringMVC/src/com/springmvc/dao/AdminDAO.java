package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Admin;

public interface AdminDAO {
	
	public boolean save(Admin admin);
	public List<Admin> findAll();
	public Admin findById(int id);
	public List<Admin> findByNombre(String nombre);
	public boolean update(Admin admin);
	public boolean delete(int idAd);
	public int[] saveAll(List<Admin> admins);

}
