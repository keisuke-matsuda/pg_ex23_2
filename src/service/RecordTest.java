package service;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecordTest {

	@Test
	public void testToString() {
		Record rc1_1 = new Record("1 090-1234-0001");
		assertEquals(rc1_1.toString(),"1 090-1234-0001");
	}

	@Test
	public void testGetRecordCode() {
		Record rc1_2 = new Record("1 090-1234-0001");
		assertEquals(rc1_2.getRecordCode(),'1');
	}

	@Test
	public void testGetOwnerTelNumber() {
		Record rc1_3 = new Record("1 090-1234-0001");
		assertEquals(rc1_3.getOwnerTelNumber(),"090-1234-0001");
	}

	@Test
	public void testGetServiceCode() {
		Record rc2_1 = new Record("2 C1 090-1234-0002");
		assertEquals(rc2_1.getServiceCode(),"C1");
	}

	@Test
	public void testGetServiceOption() {
		Record rc2_2 = new Record("2 C1 090-1234-0002");
		assertEquals(rc2_2.getServiceOption(),"090-1234-0002");
	}

	@Test
	public void testGetStartHour() {
		Record rc3_1 = new Record("5 2004/06/04 03:34 003 090-1234-0002");
		assertEquals(rc3_1.getStartHour(),3);
	}

	@Test
	public void testGetCallMinutes() {
		Record rc3_2 = new Record("5 2004/06/04 03:34 313 090-1234-0002");
		assertEquals(rc3_2.getCallMinutes(),313);
	}

	@Test
	public void testGetCallNumber() {
		Record rc3_3 = new Record("5 2004/06/04 03:34 003 090-1234-0002");
		assertEquals(rc3_3.getCallNumber(),"090-1234-0002");
	}


}
