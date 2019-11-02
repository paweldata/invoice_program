package options;

import java.util.ArrayList;
import java.util.Scanner;

import database.ProductDatabase;
import invoice.Product;

public class ProductOptions {
	private ArrayList<Product> productList;
	private ProductDatabase productDatabase;
	
	public ProductOptions() {
		this.productDatabase = new ProductDatabase();
		this.productList = productDatabase.getProductFromDatabase();
	}
	
	public ArrayList<Product> getProductList() {
		return this.productList;
	}
	
	public void addProduct() {
		String name = "";
		while(name == "") {
			name = addProductName();
		}
		Float price = addProductPrice();
		
		this.productList.add(new Product(name, price));
		
		this.productDatabase.saveProductToDatabase(productList);
	}
	
	public void showProduct() {
		for(Product product : productList) {
			System.out.println(product.getName() + " price " + product.getRecPrice());
		}
	}
	
	private String addProductName() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Name : ");
		String name = keyboard.nextLine();
		
		for(Product product : productList) {
			if (product.getName() == name) {
				System.out.println("This product already exists");
				return "";
			}
		}
		
		return name;
	}
	
	private float addProductPrice() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Price : ");
		float price = Float.parseFloat(keyboard.nextLine());
		
		return price;
	}
}
