package com.springorm.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.CellphoneRepo;
import com.springorm.model.Cellphone;

public class MainDriver {
	public static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	public static CellphoneRepo cr = ac.getBean("CellphoneRepo", CellphoneRepo.class);
	
	public static void main(String[] args) {
		cr.create(new Cellphone(1,"Phun","Y"));
		cr.create(new Cellphone(2,"Phun","X"));
		cr.create(new Cellphone(3,"Not Phun","X"));
		
		System.out.println("All Phones: " + cr.getAllPhones());
		System.out.println("By Brand X: " + cr.getPhonesByBrand("X"));
		System.out.println("By Model Phun: " + cr.getPhonesByModel("Phun"));
		
		cr.deletePhoneById(2);
		
		System.out.println("All Phones: " + cr.getAllPhones());
	}	
}
