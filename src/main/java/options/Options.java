package options;

import java.util.Scanner;

public class Options {
	private ProductOptions productOptions;
	
	public Options() {
		this.productOptions = new ProductOptions();
	}
	
	public void showMenu() {
		System.out.println("Choose :\n"
				+ "1. Add invoice\n"
				+ "2. Show invoice\n"
				+ "3. Add client\n"
				+ "4. Show client\n"
				+ "5. Add product\n"
				+ "6. Show product\n");
	}
	
	public void make() {
		Scanner keyboard = new Scanner(System.in);
		int number = keyboard.nextInt();
		
		switch(number) {
		case 5:
			this.productOptions.addProduct();
		case 6:
			this.productOptions.showProduct();
		}
			
		
	}
}
