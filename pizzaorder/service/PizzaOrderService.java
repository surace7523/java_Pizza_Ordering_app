package com.cg.pizzaorder.service;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.dao.IPizzaOrderDAO;
import com.cg.pizzaorder.dao.PizzaOrderDAO;
import com.cg.pizzaorder.exception.PizzaException;

public class PizzaOrderService implements IPizzaOrderService{

	IPizzaOrderDAO pizzaOrder;
	public PizzaOrderService()
	{
		pizzaOrder = new PizzaOrderDAO();
	}
	@Override
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException {
		
		return pizzaOrder.placeOrder(customer, pizza);
	}

	@Override
	public PizzaOrder getOrderDetails(int orderId) throws PizzaException {
		
		return pizzaOrder.getOrderDetails(orderId);
	}

}
