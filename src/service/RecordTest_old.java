package service;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecordTest_old {

	@Test
	public void testToString() {
		//head of line is "1"
		Record rc1 = new Record("1 090-1234-0001");
		assertEquals(rc1.toString()," 090-1234-0001");
	}

//	@Test
//	public void testGetRecordCode() {
//
//	}
//
//	@Test
//	public void testGetOwnerTelNumber() {
//
//	}
//
//	@Test
//	public void testGetServiceCode() {
//
//	}
//
//	@Test
//	public void testGetServiceOption() {
//
//	}
//
//	@Test
//	public void testGetStartHour() {
//
//	}
//
//	@Test
//	public void testGetCallMinutes() {
//
//	}
//
//	@Test
//	public void testGetTelNumber() {
//
//	}

}
