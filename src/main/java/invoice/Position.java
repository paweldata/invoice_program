package invoice;

import java.io.Serializable;

public class Position implements Serializable {
	private Product product;
	private Integer amount;
	private Float price;
	
	public Position(Product product, int amount, float price) {
		this.product = product;
		this.amount = amount;
		this.price = price;
	}
	
	public String getProductName() {
		return this.product.getName();
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public float getPrice() {
		return this.price;
	}
}
