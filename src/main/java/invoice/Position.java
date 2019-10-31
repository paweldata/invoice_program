package invoice;

public class Position {
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
}
