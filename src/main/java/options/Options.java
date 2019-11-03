package options;

import java.util.Scanner;

public class Options {
	private ProductOptions productOptions;
	private InvoiceOptions invoiceOptions;
	private boolean ifQuit = false;
	private Scanner keyboard = new Scanner(System.in);
	
	public Options() {
		this.productOptions = new ProductOptions();
		this.invoiceOptions = new InvoiceOptions();
	}
	
	public void getDataFromDatabase() {
		this.productOptions.getProductFromDatabase();
		this.invoiceOptions.getInvoiceToDadatase();
	}
	
	public void showMenu() {
		System.out.println("Choose :\n"
				+ "1. Add invoice\n"
				+ "2. Show invoice\n"
				+ "3. Add product\n"
				+ "4. Show product\n"
				+ "5. Quit");
	}
	
	public void make() {
		int number = Integer.parseInt(keyboard.nextLine());
		
		switch(number) {
		case 1:
			this.invoiceOptions.addInvoice(this.productOptions.getProductList());
			break;
		case 2:
			this.invoiceOptions.showInvoice();
			break;
		case 3:
			this.productOptions.addProduct();
			break;
		case 4:
			this.productOptions.showProduct();
			break;
		case 5:
			this.ifQuit = true;
			break;
		default:
			System.out.println("Wrong number");
		}
	}
	
	public boolean endProgram() {
		return this.ifQuit;
	}
}
