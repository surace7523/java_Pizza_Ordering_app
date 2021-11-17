package com.cg.pizzaorder.bean;

public class PizzaOrder {

	private int orderId;
	private int customerId;
	private double totalPrice;
	
	public PizzaOrder(int orderId, int customerId, double totalPrice) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Pizza Id=" + orderId + ", Customer Id=" + customerId + ", Total Price=" + totalPrice ;
	}
	
	
	
}
