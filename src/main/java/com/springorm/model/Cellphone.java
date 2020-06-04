package com.springorm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cellphones")
public class Cellphone {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "model")
	private String model;
	@Column(name = "brand")
	private String brand;
	public Cellphone() {
		super();
	}
	public Cellphone(int id, String model, String brand) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Cellphone [id=" + id + ", model=" + model + ", brand=" + brand + "]";
	}
}
