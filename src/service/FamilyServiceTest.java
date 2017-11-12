package service;

import static org.junit.Assert.*;

import org.junit.Test;

public class FamilyServiceTest {

	@Test
	public void testIsFamilyNumber() {
		FamilyService tf1 = new FamilyService();
		Record tr1_1 = new Record("2 C1 090-1234-0002");
		Record tr1_2 = new Record("2 C1 090-1234-0003");
		Record tr1_3 = new Record("5 2004/06/04 03:34 003 090-1234-0002");
		Record tr1_4 = new Record("5 2004/06/04 13:50 010 090-1234-9999");
		tf1.checkService(tr1_1);
		tf1.checkService(tr1_2);

		assertTrue(tf1.isFamilyTelNumber("090-1234-0002"));
		assertTrue(tf1.isFamilyTelNumber("090-1234-0003"));
		assertFalse(tf1.isFamilyTelNumber("012-3456-7890"));

	}

	@Test
	public void testCheckService() {
		FamilyService tf2 = new FamilyService();
		Record tr2_1 = new Record("2 C1 090-1234-0002");
		Record tr2_2 = new Record("2 C1 090-1234-0002");
		Record tr2_3 = new Record("2 E1");
		Record tr2_4 = new Record("5 2004/06/04 03:34 003 090-1234-0002");
		Record tr2_5 = new Record("5 2004/06/04 13:50 010 090-1234-9999");
		tf2.checkService(tr2_1);
		tf2.checkService(tr2_2);
		tf2.checkService(tr2_3);
		assertTrue(tf2.isJoined());
		assertEquals(tf2.testTelNumberCount(), 2);
		tf2.clear();
		assertEquals(tf2.testTelNumberCount(), 0);
	}

	@Test
	public void testCalcUnitPrice() {
		FamilyService tf3 = new FamilyService();
		Record tr3_1 = new Record("2 C1 090-1234-0002");
		Record tr3_2 = new Record("2 C1 090-1234-0002");
		Record tr3_3 = new Record("2 E1");
		Record tr3_4 = new Record("5 2004/06/04 03:34 003 090-1234-0002");
		Record tr3_5 = new Record("5 2004/06/04 13:50 010 090-1234-9999");
		tf3.checkService(tr3_1);
		tf3.checkService(tr3_2);
		tf3.checkService(tr3_3);
		assertEquals(tf3.calcBasicCharge(1000), 1100);
	}

	@Test
	public void testCalcBasicCharge() {
		FamilyService tf4 = new FamilyService();
		Record tr4_1 = new Record("2 C1 090-1234-0002");
		Record tr4_2 = new Record("2 C1 090-1234-0002");
		Record tr4_3 = new Record("2 E1");
		Record tr4_4 = new Record("5 2004/06/04 03:34 003 090-1234-0002");
		Record tr4_5 = new Record("5 2004/06/04 13:50 010 090-1234-9999");
		tf4.checkService(tr4_1);
		tf4.checkService(tr4_2);
		tf4.checkService(tr4_3);
		assertEquals(tf4.calcUnitPrice(tr4_4, 20),10);
		assertEquals(tf4.calcUnitPrice(tr4_5, 20),20);
		assertEquals(tf4.calcUnitPrice(tr4_4, 15),7);
	}
}
