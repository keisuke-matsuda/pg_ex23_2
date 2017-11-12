package service;

import static org.junit.Assert.*;

import org.junit.Test;

public class ServiceCollectionTest {

	@Test
	public void testCalcBasicCharge() {
		Service ts1 = new ServiceCollection();
		Record tr1_1 = new Record("2 C1 090-1234-0002");
		Record tr1_2 = new Record("2 C1 090-1234-1234");
		Record tr1_3 = new Record("2 E1");
		ts1.checkService(tr1_1);
		ts1.checkService(tr1_2);
		ts1.checkService(tr1_3);
		assertEquals(ts1.calcBasicCharge(1000),1300);

		Service ts2 = new ServiceCollection();
		Record tr2_1 = new Record("2 C1 090-1234-0002");
		Record tr2_2 = new Record("2 C1 090-1234-1234");
		ts2.checkService(tr2_1);
		ts2.checkService(tr2_2);
		assertEquals(ts2.calcBasicCharge(1000),1100);

		Service ts3 = new ServiceCollection();
		Record tr3_1 = new Record("2 E1");
		ts3.checkService(tr3_1);
		assertEquals(ts3.calcBasicCharge(1000),1200);

	}

	@Test
	public void testCalcUnitPrice() {
		Service ts1 = new ServiceCollection();
		Record tr1_1 = new Record("2 C1 090-1234-0002");
		Record tr1_2 = new Record("2 C1 090-1234-1234");
		Record tr1_3 = new Record("2 E1");
		Record tr1_4 = new Record("5 2004/06/04 03:34 003 090-1234-0002");
		Record tr1_5 = new Record("5 2004/06/04 13:50 010 090-1234-9999");
		Record tr1_6 = new Record("5 2004/06/04 13:50 010 090-1234-1234");
		ts1.checkService(tr1_1);
		ts1.checkService(tr1_2);
		ts1.checkService(tr1_3);
		assertEquals(ts1.calcUnitPrice(tr1_4,20),10);
		assertEquals(ts1.calcUnitPrice(tr1_5,20),15);
		assertEquals(ts1.calcUnitPrice(tr1_6,20),7);
	}

}
