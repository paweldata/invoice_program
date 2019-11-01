package invoice;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;

public class Invoice implements Serializable {
	private ArrayList<Position> positionList;
	private String customer;
	private Date date;
	private Integer id;
	
	public Invoice(ArrayList<Position> positionList, String customer, int id) {
		this.positionList = new ArrayList<Position>();
		
		for(Position position : positionList)
			this.positionList.add(position);
		
		this.customer = customer;
		this.date = new Date();
		this.id = id;
	}
	
	public ArrayList<Position> getPositionList() {
		return this.positionList;
	}
	
	public String getCustomer() {
		return this.customer;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Date getDate() {
		return this.date;
	}
}
