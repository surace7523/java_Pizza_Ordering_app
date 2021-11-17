package com.cg.pizzaorder.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;

public class PizzaOrderDAO implements IPizzaOrderDAO {

	Map<Integer,PizzaOrder> pizzaEntry;
	Map<Integer,Customer> customerEntry;
	
	public PizzaOrderDAO()
	{
		pizzaEntry = new HashMap<>();
		customerEntry = new HashMap<>();
	}
	
	
	@Override
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException {
		
		if(pizza == null)
			throw new PizzaException("Pizza order not found");
		int orderId = pizza.getOrderId();
		
		//Check if order with same id already exists
		if(pizzaEntry.get(orderId)!=null)
			throw new PizzaException("Pizza order with same ID: "+ orderId+" already exists");
		int custId = customer.getCustomerId();
		
		//check if customer already exists
		if(customerEntry.get(custId)!=null)
			throw new PizzaException("Customer with same ID: "+ custId+" already exists");
		
		//add Pizza Order
		pizzaEntry.put(orderId, pizza);
		//add Customer
		customerEntry.put(custId, customer);
		
		return orderId;
	}

	@Override
	public PizzaOrder getOrderDetails(int orderId) throws PizzaException {
		
		//Check if Pizza Order with given ID doesn't exists.
		if(pizzaEntry.get(orderId) == null)
			throw new PizzaException("Pizza order not found");
		
		return pizzaEntry.get(orderId);
	}
	
}
