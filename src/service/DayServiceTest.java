package service;

import static org.junit.Assert.*;

import org.junit.Test;

public class DayServiceTest {

	@Test
	public void testIsServiceTime() {
		DayService testds1 = new DayService();
		assertTrue(testds1.isServiceTime(15));
		assertFalse(testds1.isServiceTime(18));
	}

	@Test
	public void testCheckService() {
		DayService testds2 = new DayService();
		Record tr2 = new Record("2 E1");
		testds2.checkService(tr2);
		assertTrue(testds2.isJoined());
	}

	@Test
	public void testgetUnitPrice() {
		Service ts3 = new DayService();
		Record tr3_1 = new Record("5 2004/06/05 17:50 010 090-1234-9999");
		Record tr3_2 = new Record("2 E1");
		ts3.checkService(tr3_2);
		assertEquals(ts3.calcUnitPrice(tr3_1,20),15);
	}

	@Test
	public void testgetBasicCharge() {
		Service ts4 = new DayService();
		Record tr4 = new Record("2 E1");
		ts4.checkService(tr4);
		assertEquals(ts4.calcBasicCharge(1000),1200);
	}

}
