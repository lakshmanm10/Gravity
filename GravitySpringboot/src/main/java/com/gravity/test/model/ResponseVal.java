package com.gravity.test.model;

import java.util.List;

public class ResponseVal {

	List<Integer> discountedList;
	List<Integer> payableList;
	
	public List<Integer> getDiscountedList() {
		return discountedList;
	}
	public void setDiscountedList(List<Integer> discountedList) {
		this.discountedList = discountedList;
	}
	public List<Integer> getPayableList() {
		return payableList;
	}
	public void setPayableList(List<Integer> payableList) {
		this.payableList = payableList;
	}
}
