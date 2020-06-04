package com.springorm.dao;

import java.util.List;


import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springorm.model.Cellphone;

@Repository("CellphoneRepo")
public class CellphoneRepo {
	
	private SessionFactory sf;
	
	@Autowired
	public CellphoneRepo(SessionFactory sf) {
		this.sf = sf;
	}
	
	// CRUD
	// CREATE
	@Transactional
	public void create(Cellphone c) {
		try (Session s = sf.openSession()) {
			Transaction t = s.beginTransaction();
			s.save(c);
			t.commit();
			s.close();
		}
	}
	
	// READ
	@Transactional
	public Cellphone getPhoneById(int id) {
		return sf.getCurrentSession().createQuery("from Cellphone where id = '" + id + "'", Cellphone.class).getSingleResult();
	}
	@Transactional
	public List<Cellphone> getAllPhones() {
		Session s = sf.openSession();
		return s.createQuery("from Cellphone", Cellphone.class).list();
	}
	@Transactional
	public List<Cellphone> getPhonesByBrand(String brand) {
		return sf.getCurrentSession().createQuery("from Cellphone where brand = '" + brand + "'", Cellphone.class).list();
	}
	@Transactional
	public List<Cellphone> getPhonesByModel(String model) {
		return sf.getCurrentSession().createQuery("from Cellphone where model = '" + model + "'", Cellphone.class).list();
	}
	// UPDATE
	@Transactional
	public void updatePhone(Cellphone c) {
		// I don't really follow what this does....
		sf.getCurrentSession().update(c);
	}
	// DELETE
	@Transactional
	public void deletePhoneById(int id) {
		sf.getCurrentSession().delete(getPhoneById(id));
	}
	@Transactional
	public void deletePhone(Cellphone c) {
		sf.getCurrentSession().delete(c);
	}
}
