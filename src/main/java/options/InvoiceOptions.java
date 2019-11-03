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
	private Scanner keyboard = new Scanner(System.in);
	
	public InvoiceOptions() {
		this.invoiceDatabase = new InvoiceDatabase();
	}
	
	public void getInvoiceToDadatase() {
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

		for (Position position : positionList) {
			System.out.println(position.getProductName() + "\t"
							+ + position.getAmount()+ " * " + position.getPrice()
							+ " = " + position.getPrice() * position.getAmount());
		}
		
		System.out.println("Total :\t" + this.addTotal(positionList));
	}
	
	public float addTotal(ArrayList<Position> positionList) {
		float total = 0;
		for (Position position : positionList)
			total += position.getPrice() * position.getAmount();
		return total;
	}
	
	private String getCustomer() {
		System.out.print("Customer : ");
		String customer = keyboard.nextLine();
		
		return customer;
	}
	
	private ArrayList<Position> getPositionList(ArrayList<Product> productList) {
		ArrayList<Position> positionList = new ArrayList<Position>();
		boolean ifNewPosition = true;
		
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
		int id = Integer.parseInt(keyboard.nextLine());
		
		return invoiceList.get(id);
	}
}
