package test;

import java.util.ArrayList;

import org.junit.Test;

import invoice.Position;
import invoice.Product;
import options.InvoiceOptions;

public class TestClass {
	
	@Test
	public void test1() {
		ArrayList<Position> positionList = new ArrayList<Position>();
		positionList.add(new Position(new Product("A", (float)1.0), 5, (float)1.0));
		positionList.add(new Position(new Product("B", (float)2.0), 5, (float)2.0));
		assert(InvoiceOptions.addTotal(positionList) == 15);
	}
	
	@Test
	public void test2() {
		ArrayList<Position> positionList = new ArrayList<Position>();
		positionList.add(new Position(new Product("A", (float)1.0), 5, (float)2.0));
		positionList.add(new Position(new Product("B", (float)2.0), 5, (float)3.0));
		assert(InvoiceOptions.addTotal(positionList) == 25);
	}
}
