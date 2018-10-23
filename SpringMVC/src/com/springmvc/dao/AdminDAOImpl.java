package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.springmvc.model.Admin;

@Component("adminDAO")
public class AdminDAOImpl implements AdminDAO{
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDataSourceTag(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		};
		
		
	@Override
	public boolean save(Admin admin) {
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);

		return jdbcTemplate.update("INSERT INTO tbl_administrador(nombre,cargo,fechaCreacion) VALUES(:nombre,:cargo,:fechaCreacion)", paramMap)==1;
	}

	@Override
	public List<Admin> findAll() {
		
		return jdbcTemplate.query("SELECT * FROM tbl_administrador", new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int arg1) throws SQLException {
				Admin obj = null;
				for(int i = 0 ; i < arg1 ; i++) {
				 obj = new Admin(rs.getInt("codigo"),rs.getString("nombre"), rs.getString("cargo"),rs.getTimestamp("fechaCreacion"));
				}		
				return obj;
			}
		});
	}

	@Override
	public Admin findById(int id) {
		Admin objrs= (Admin) jdbcTemplate.query("SELECT * FROM tbl_administrador WHERE codigo = :param_codigo", new MapSqlParameterSource(":param_codigo",id),new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int arg1) throws SQLException {
				Admin instancia = new Admin();
				instancia.setCodigo(rs.getInt("codigo"));
				instancia.setNombre(rs.getString("nombre"));
				instancia.setCargo(rs.getString("cargo"));
				instancia.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
				return instancia;
			}
		} );
		return objrs;
	}

	@Override
	public List<Admin> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int idAd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] saveAll(List<Admin> admins) {
		// TODO Auto-generated method stub
		return null;
	}

}
