package practice1.shoppingStore;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;


public class App {
	
	
	
	
    public static void main( String[] args ) throws SQLException {
		
    	Product shopProducts = new Product();
    	List<Product> listOfShopProducts = new ArrayList<Product>();
		listOfShopProducts = shopProducts.getAllProducts();   
		 
    	System.out.println("Welcome to the General Store ");
    	System.out.println("Various goods are sold here from books to groceries! ");
    	System.out.println();
    	for(Product productList : listOfShopProducts) {
    		BigDecimal priceBD = new BigDecimal(productList.getPrice());
    		System.out.println(productList.getName() + " " + " $" + priceBD.setScale(2, RoundingMode.HALF_UP) + " " 
    							+ productList.getQuantity());
    	}
    	
    	System.out.println();
    	System.out.println("Add money to your account:");
    	
    	
    	@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
    	String myKeyboard = userInput.nextLine();
    	
    	Customer aCustomer = new Customer();
    	List<Product> cart = new ArrayList<Product>();
    	double totalPrice = 0.00;
    	BigDecimal totalPriceBD = null;
    	
    	aCustomer.setTotalAmountInWallet(Double.parseDouble(myKeyboard));
    	BigDecimal amtInWalletBD = new BigDecimal(aCustomer.getTotalAmountInWallet());
    	System.out.println("Total Money in Account: $" + amtInWalletBD.setScale(2, RoundingMode.HALF_UP));
    	
    	String addingToCart = "";
    	System.out.println("Shopping?: (Y/N):");
    	String shopping = userInput.nextLine();
    	addingToCart = shopping;
    	
    	while(addingToCart.equalsIgnoreCase("Y")) {
    		
    		Product customerProduct = new Product();
    		
    		System.out.println("Select item:");
    		String itemSelected = userInput.nextLine();
    		customerProduct.setName(itemSelected);
    		
    		System.out.println("How many?:");
    		String quantitySelected = userInput.nextLine();
    		int chosenQuantity = Integer.parseInt(quantitySelected);
    		customerProduct.setQuantity(chosenQuantity);
    		
    		if(chosenQuantity <= customerProduct.getProductQuantity(itemSelected) || itemSelected.equalsIgnoreCase(customerProduct.getProductName(itemSelected))) {
    			totalPrice += (customerProduct.getProductPrice(itemSelected) * chosenQuantity);
    			totalPriceBD = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP);
    			cart.add(customerProduct);    	
    		}
    		else {
    			System.out.println("Sorry, but either the product is available or there is simply not enough in stock.");
    		}
    		
    		System.out.println("Still Shopping? (Y/N)");
    		String stillShopping = userInput.nextLine();
    		addingToCart = stillShopping;
    	} 
    	
    	if(addingToCart.equalsIgnoreCase("N")) {
    		System.out.println("Would you like to proceed to checkout?(Y/N)");
    		String checkout = userInput.nextLine();
    		if(checkout.equalsIgnoreCase("Y")) {
    			System.out.println("Total is $" + totalPriceBD);
    			if(totalPrice < aCustomer.getTotalAmountInWallet()) {
    				double customerChange = aCustomer.getTotalAmountInWallet() - totalPrice;
    				BigDecimal customerChangeBD = new BigDecimal(customerChange).setScale(2, RoundingMode.HALF_UP);
    				System.out.println("Your change is $" + customerChangeBD + ". Have a great day!");
    			}
    			else {
    				System.out.println("You don't have enough money in your wallet. Would you like to add more?(Y/N)");
    				String addMoreMoney = userInput.nextLine();
    				if(addMoreMoney.equalsIgnoreCase("Y")) {
    					System.out.println("Please add more money:");
    					String moreMoneyToWallet = userInput.nextLine();
    					double moneyAdded = Double.parseDouble(moreMoneyToWallet);
    					aCustomer.setTotalAmountInWallet(aCustomer.getTotalAmountInWallet() + moneyAdded);
    					double customerChange2 = aCustomer.getTotalAmountInWallet() - totalPrice;
        				BigDecimal customerChangeBD2 = new BigDecimal(customerChange2).setScale(2, RoundingMode.HALF_UP);
        				System.out.println("Amount in wallet: $" + customerChangeBD2);
        				System.out.println("Procced to checkout?(Y/N)");
        				String checkout2 = userInput.nextLine();
        				if(checkout2.equalsIgnoreCase("Y")) {
        				System.out.println("Your change is $" + customerChangeBD2 + ". Have a great day!");
        				}
        				else {
        					
        					System.out.println("Thank you for visiting this online store. Come back soon and Have a great day!");
        				}
        				
    				}
    				else {
    					System.out.println("Thank you for visiting this online store. Come back soon and Have a great day!");
    				}
    			}
    		}
    		else {
    			System.out.println("Thank you for visiting this online store. Come back soon and Have a great day!");
    		}
    	}
       
    	
    }
}
