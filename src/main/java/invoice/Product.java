package invoice;

import java.io.Serializable;

public class Product implements Serializable {
	private String name;
	private Float recommendedPrice;
	
	public Product(String name, Float recommendedPrice) {
		this.name = name;
		this.recommendedPrice = recommendedPrice;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Float getRecPrice() {
		return this.recommendedPrice;
	}
}
