package com.yebelo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category_Value")
public class CategoryValueEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CategoryCode;
	
	private int Value;

	public int getCategoryCode() {
		return CategoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		CategoryCode = categoryCode;
	}

	public int getValue() {
		return Value;
	}

	public void setValue(int value) {
		Value = value;
	}
}
