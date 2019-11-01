package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import invoice.Product;

public class ProductDatabase {
	
	public ArrayList<Product> getProductFromDatabase() {
		ObjectInputStream file = null;
		
		ArrayList<Product> productList = new ArrayList<Product>()
;		
		try {
			file = new ObjectInputStream(new FileInputStream("product"));
			productList = (ArrayList<Product>)file.readObject();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return productList;
	}
	
	public void saveProductToDatabase(ArrayList<Product> productList) {
		try {
            FileOutputStream fileOut = new FileOutputStream("product");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(productList);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
