package com.mvc.beans;

public class CategoryBean {
	/*
	 * @Author : Rahul
	 * 
	 * @Date: 16-11-2023
	 * 
	 * @Version: 1.0
	 * 
	 * @Purpose : Bean/Model class for Category
	 */
	private int caId;
	private String caName;

	public int getCaId() {
		return caId;
	}

	public void setCaId(int caId) {
		this.caId = caId;
	}

	public String getCaName() {
		return caName;
	}

	public void setCaName(String caName) {
		this.caName = caName;
	}
}