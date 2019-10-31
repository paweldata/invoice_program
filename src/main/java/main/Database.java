package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import invoice.*;

public class Database {
	public Database() {
		//connect to database
	}
	
	public ArrayList<Product> getProductList() {
		ArrayList<Product> productList = new ArrayList<Product>();
		
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("product.csv"));
			
			String row;
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(";");
			    productList.add(new Product(data[0], Float.parseFloat(data[1])));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return productList;
	}
	
	public void addNewProduct(Product product) {
		try {
			FileWriter csvWriter = new FileWriter("new.csv", true);
			csvWriter.append(product.getName() + ";" + product.getRecPrice());
			
			csvWriter.flush();
	        csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
