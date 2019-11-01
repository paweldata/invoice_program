package options;

import java.util.ArrayList;
import java.util.Scanner;

import database.InvoiceDatabase;
import invoice.Invoice;
import invoice.Position;
import invoice.Product;

public class InvoiceOptions {
	private ArrayList<Invoice> invoiceList;
	private InvoiceDatabase invoiceDatabase;
	
	public InvoiceOptions() {
		this.invoiceDatabase = new InvoiceDatabase();
		this.invoiceList = invoiceDatabase.getInvoiceFromDatabase();
		//this.invoiceList = new ArrayList<Invoice>();
	}
	
	public void addInvoice(ArrayList<Product> productList) {
		String customer = this.getCustomer();
		ArrayList<Position> positionList = getPositionList(productList);
		
		this.invoiceList.add(new Invoice(positionList, customer, invoiceList.size()));
		this.invoiceDatabase.saveInvoiceToDatabase(this.invoiceList);
	}
	
	public void showInvoice() {
		Invoice invoice = getInvoice();
		System.out.println("Id : " + invoice.getId()
						+ "\nCustomer : " + invoice.getCustomer()
						+ "\nDate : " + invoice.getDate());
		
		ArrayList<Position> positionList = invoice.getPositionList();
		
		for (Position position : positionList) {
			System.out.println(position.getProductName() + " "
							+ "amount : " + position.getAmount()
							+ "price :" + position.getPrice() * position.getAmount());
		}
	}
	
	private String getCustomer() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Customer : ");
		String customer = keyboard.nextLine();
		
		return customer;
	}
	
	private ArrayList<Position> getPositionList(ArrayList<Product> productList) {
		ArrayList<Position> positionList = new ArrayList<Position>();
		boolean ifNewPosition = true;
		Scanner keyboard = new Scanner(System.in);
		
		while(ifNewPosition) {
			for (int i = 0; i < productList.size(); i++) {
				System.out.println(i + ". " + productList.get(i).getName());
			}
			
			System.out.print("Choose product : ");
			int productNumber = Integer.parseInt(keyboard.nextLine());
			
			System.out.println("Recommednded price : " + productList.get(productNumber).getRecPrice());
			System.out.print("Actual price : ");
			float productPrice = Float.parseFloat(keyboard.nextLine());
			
			System.out.print("Amount : ");
			int amount = Integer.parseInt(keyboard.nextLine());
			
			positionList.add(new Position(productList.get(productNumber), amount, productPrice));
			
			System.out.println("Next product? 1- yes, 2- no");
			int answer = Integer.parseInt(keyboard.nextLine());
			if (answer == 2) {
				ifNewPosition = false;
			}
		}
		
		return positionList;
	}
	
	private Invoice getInvoice() {
		for (Invoice invoice : invoiceList)
			System.out.println(invoice.getId() + " " + invoice.getCustomer());
		
		System.out.println("Invoice id : ");
		Scanner keyboard = new Scanner(System.in);
		int id = Integer.parseInt(keyboard.nextLine());
		
		return invoiceList.get(id);
		
	}
}
