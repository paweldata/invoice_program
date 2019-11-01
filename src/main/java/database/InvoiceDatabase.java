package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

import invoice.Invoice;

public class InvoiceDatabase {
	
	public ArrayList<Invoice> getInvoiceFromDatabase() {
		ObjectInputStream file = null;
		
		ArrayList<Invoice> invoiceList = new ArrayList<Invoice>()
;		
		try {
			file = new ObjectInputStream(new FileInputStream("invoice.txt"));
			invoiceList = (ArrayList<Invoice>)file.readObject();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return invoiceList;
	}
	
	public void saveInvoiceToDatabase(ArrayList<Invoice> invoiceList) {
		try {
            FileOutputStream fileOut = new FileOutputStream("invoice.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(invoiceList);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}

