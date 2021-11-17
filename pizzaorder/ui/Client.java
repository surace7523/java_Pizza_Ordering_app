package com.cg.pizzaorder.ui;

import java.util.Date;
import java.util.Scanner;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;
import com.cg.pizzaorder.service.IPizzaOrderService;
import com.cg.pizzaorder.service.PizzaOrderService;

public class Client {

	//Main Method
	public static void main(String[] args) throws PizzaException {
		Scanner input = new Scanner(System.in);
		IPizzaOrderService pizzaService = new PizzaOrderService();
		boolean exit = false;
		while(true)
		{
			displayMenu();
			switch(input.nextInt())
			{
			case 1:
				//Auto-Generated IDs
				int orderID = (int) (Math.random()*20000);
				int custID = (int) (Math.random()*20000);
				
				double totalPrice = 350;
				
				System.out.print("Customer name: ");
				String name =  input.next();
				
				System.out.print("Customer Address: ");
				String addr = input.next();
				
				System.out.print("Phone Number: ");
				String phone = input.next();
				
				//Validation on Phone
				if(phone.length()==10 && phone.matches("[0-9]+"))
				{
					System.out.print("Type of Topping preffered: ");
					String topping = input.next();
					
					//Calculating Price for Topping
					switch(topping)
					{
					case "Capsicum":
						totalPrice = totalPrice + 30;
						System.out.println("Price: (To be Calculated: Rs. 350 + 30(Capsicum) )= "+totalPrice);
						break;
					case "Mushroom":
						totalPrice = totalPrice + 50;
						System.out.println("Price: (To be Calculated: Rs. 350 + 50(Mushroom) )= "+totalPrice);
						break;
					case "Jalapeno":
						totalPrice = totalPrice + 70;
						System.out.println("Price: (To be Calculated: Rs. 350 + 70(Jalapeno) )= "+totalPrice);
						break;
					case "Paneer":
						totalPrice = totalPrice + 85;
						System.out.println("Price: (To be Calculated: Rs. 350 + 85(Paneer) )= "+totalPrice);
						break;
						
					default:
						System.out.println("Price: (To be Calculated: Rs. 350 (without Topping) )= "+totalPrice);
					}
					
					//Current System Date and time
					Date date = new Date();
					System.out.println("Date: "+date);
					
					//Placing Order
					System.out.println("Pizza Order successfully placed with Order id: "+pizzaService.placeOrder(new Customer(custID,name,addr,phone), new PizzaOrder(orderID,custID,totalPrice)));
				}
				else
				{
					System.out.println("Invalid Phone number.");
				}
				
				break;
			case 2:
				System.out.print("Order ID: ");
				//Searching OrderDetail
				System.out.println(pizzaService.getOrderDetails(input.nextInt()));
				break;
			case 3:
				exit = true;
				break;
			default:
				System.out.println("Invalid Choice\n");
			}
			if(exit)
				break;
			
			
			
		}

	}

	//Menu to be displayed in the start of program
	private static void displayMenu() {
		System.out.println("=========Menu=======");
		System.out.println("1. Place Order");
		System.out.println("2. Display Order");
		System.out.println("3. Exit");
		System.out.println("====================");
		
	}

}
