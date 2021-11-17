package com.cg.pizzaorder.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;

public class TestDAO {

	//Test DAO Class is working correctly or not
	@Test
	public void test() throws PizzaException {
		Customer customer = new Customer(1234, "John", "Dallas", "9786845321");
		PizzaOrder order = new PizzaOrder(2000, 1234, 400.0);
		IPizzaOrderDAO pizzaOrder = new PizzaOrderDAO();
		int orderID = pizzaOrder.placeOrder(customer, order);
		
		assertEquals(orderID,2000);
		
		PizzaOrder retOrder = pizzaOrder.getOrderDetails(orderID);
		assertEquals(retOrder.getCustomerId(),1234);
		assertEquals((int)retOrder.getTotalPrice(),400);
		
	}

}
