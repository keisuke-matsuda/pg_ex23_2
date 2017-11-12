package service;

import java.util.Arrays;

public class FamilyService implements Service {

	private static final int TEL_NUMBER = 2;
	private static final String SERVICE_CODE = "C1";
	private static final int BASIC_CHARGE = 100;
	private boolean joined = false;
	private String[] telNumbers = new String[TEL_NUMBER];
	private int telNumberCount = 0;

	public void clear() {
		this.telNumberCount = 0;
		for (int n = 0; n < TEL_NUMBER; n++) {
			telNumbers[n] = null;
		}
		joined = false;
	}

	public void appendFamilyTelNumber(String telNumber) {
		if (this.telNumberCount <= TEL_NUMBER) {
			telNumbers[this.telNumberCount] = telNumber;
			this.telNumberCount++;
		}
	}

	public boolean isJoined() {
		return joined;
	}

	public boolean isFamilyTelNumber(String telNumber) {
		return Arrays.asList(telNumbers).contains(telNumber);
	}

	public void checkService(Record record) {
		if (record.getServiceCode().equals(SERVICE_CODE)) {
			this.joined = true;
			this.appendFamilyTelNumber(record.getServiceOption());
		}

	}

	public int calcUnitPrice(Record record, int unitPrice) {
		if (this.isFamilyTelNumber(record.getCallNumber())) {
			return unitPrice/2;
		}else{
		return unitPrice;
		}
	}

	public int calcBasicCharge(int basicCharge) {
		if (this.isJoined() == true) {
			return basicCharge + BASIC_CHARGE;
		}
		return basicCharge;
	}

	// テスト用メソッド#1
	public int testTelNumberCount() {
		return this.telNumberCount;
	}

	// テスト用メソッド#2
	public String testAppendedTelNumber(int i) {
		return this.telNumbers[i];
	}
}
