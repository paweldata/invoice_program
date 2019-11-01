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
	}
	
	public void addInvoice(ArrayList<Product> productList) {
		String customer = this.getCustomer();
		ArrayList<Position> positionList = getPositionList(productList);
		
		this.invoiceList.add(new Invoice(positionList, customer, invoiceList.size()));
		this.invoiceDatabase.saveInvoiceToDatabase(this.invoiceList);
	}
	
	public void showInvoice() {
		Invoice invoice = getInvoice();
		System.out.println("Id :\t" + invoice.getId()
						+ "\nCustomer :\t" + invoice.getCustomer()
						+ "\nDate :\t" + invoice.getDate());
		
		ArrayList<Position> positionList = invoice.getPositionList();
		
		float total = 0;
		for (Position position : positionList) {
			System.out.println(position.getProductName() + "\t"
							+ + position.getAmount()+ " * " + position.getPrice()
							+ " = " + position.getPrice() * position.getAmount());
			total += position.getAmount() * position.getPrice();
		}
		
		System.out.println("Total :\t" + total);
	}
	
	private String getCustomer() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Customer : ");
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
		System.out.println("Id\tCustomer");
		for (Invoice invoice : invoiceList)
			System.out.println(invoice.getId() + "\t" + invoice.getCustomer());
		
		System.out.print("Invoice id : ");
		Scanner keyboard = new Scanner(System.in);
		int id = Integer.parseInt(keyboard.nextLine());
		
		return invoiceList.get(id);
	}
}
