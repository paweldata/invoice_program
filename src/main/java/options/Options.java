package options;

import java.util.Scanner;

public class Options {
	private ProductOptions productOptions;
	private InvoiceOptions invoiceOptions;
	
	public Options() {
		this.productOptions = new ProductOptions();
		this.invoiceOptions = new InvoiceOptions();
	}
	
	public void showMenu() {
		System.out.println("Choose :\n"
				+ "1. Add invoice\n"
				+ "2. Show invoice\n"
				+ "3. Add product\n"
				+ "4. Show product\n");
	}
	
	public void make() {
		Scanner keyboard = new Scanner(System.in);
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
		}
			
		
	}
}
