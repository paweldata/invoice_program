package test;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import invoice.Position;
import invoice.Product;
import options.InvoiceOptions;

public class TestClass {
	private InvoiceOptions invoiceOptions;
	private ArrayList<Position> positionList1;
	private ArrayList<Position> positionList2;
	
	@Before
	public void before() {
		this.invoiceOptions = new InvoiceOptions();
		
		positionList1 = new ArrayList<Position>();
		positionList1.add(new Position(new Product("A", (float)1.0), 5, (float)1.0));
		positionList1.add(new Position(new Product("B", (float)2.0), 5, (float)2.0));

		positionList2 = new ArrayList<Position>();
		positionList2.add(new Position(new Product("A", (float)1.0), 5, (float)2.0));
		positionList2.add(new Position(new Product("B", (float)2.0), 5, (float)3.0));
	}
	
	@Test
	public void test1() {
		assert(this.invoiceOptions.addTotal(positionList1) == 15);
	}
	
	@Test
	public void test2() {
		assert(this.invoiceOptions.addTotal(positionList2) == 25);
	}
}
