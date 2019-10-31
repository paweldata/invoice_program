package invoice;

import java.util.Date;
import java.util.ArrayList;

public class Invoice {
	private ArrayList<Position> positionList;
	private String customer;
	private Date date;
	private Integer id;
	
	public Invoice(ArrayList<Position> positionList, String costumer, Date date) {
		this.positionList = new ArrayList<Position>();
		
		for(Position position : positionList)
			this.positionList.add(position);
		
		this.customer = customer;
		this.date = new Date();
		//this.id = getInvoiceNumber
	}
}
