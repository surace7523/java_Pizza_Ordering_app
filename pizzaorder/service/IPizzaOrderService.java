package com.cg.pizzaorder.service;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;

public interface IPizzaOrderService {

	/**
	 * Mathod to place an Pizza order for customer
	 * @param customer Object of <code>Customer</code> class contains detail of Customer
	 * @param pizza Object of <code>PizzaOrder</code> class contains detail of Pizza Order
	 * @return Id of order that is placed successfully
	 * @throws PizzaException if Order is null or Order with same Id is already Placed
	 */
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException;
	
	/**
	 * Method to get the detail of specific Order
	 * @param orderId Id of an Order you want to retrieve
	 * @return Object of <code>PizzaOrder</code> class contains detail of Pizza Order 
	 * @throws PizzaException if Order with given Id doesn't exists.
	 */
	public PizzaOrder getOrderDetails(int orderId) throws PizzaException;
}
