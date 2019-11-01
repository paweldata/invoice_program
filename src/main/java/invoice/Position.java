package invoice;

import java.io.Serializable;

public class Position implements Serializable {
	private Product product;
	private Integer amount;
	private Float price;
	private Integer id;
	
	public Position(Product product, int amount, float price) {
		this.product = product;
		this.amount = amount;
		this.price = price;
		//this.id = getPositionNumber
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
	
	public int getId() {
		return this.id;
	}
}
