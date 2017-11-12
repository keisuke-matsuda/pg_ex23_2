package service;

public class DayService extends TimeService {

	private static final int START_TIME = 8;
	private static final int END_TIME = 17;
	private static final String SERVICE_CODE = "E1";
	private static final int BASIC_CHARGE = 200;
	private static final int DISCOUNT_PERMIN = 5;
	private boolean joined = false;

	public void clear() {
		this.joined = false;
	}

	public boolean isServiceTime(int hour) {
		if (START_TIME <= hour & hour <= END_TIME) {
			return true;
		}
		return false;
	}

	public String getServiceCode() {
		return SERVICE_CODE;
	}

	public void checkService(Record record) {
		if (record.getServiceCode().equals(SERVICE_CODE)) {
			this.joined = true;
		}
	}

	public boolean isJoined() {
		return joined;
	}

	public int getDiscount() {
		return DISCOUNT_PERMIN;
	}

	public int calcBasicCharge(int basicCharge) {
		if(this.isJoined()){
			return basicCharge + BASIC_CHARGE;
		}else{
			return basicCharge;
		}
	}

	public int getBasicCharge() {
		return 0;
	}

	public int calcUnitPrice(Record record, int unitPrice) {
		boolean isServiceTime = false;
		this.checkService(record);
		isServiceTime = this.isServiceTime(record.getStartHour());
		if (this.isJoined() & isServiceTime) {
			return unitPrice - DISCOUNT_PERMIN;
		} else {
			return unitPrice;
		}
	}

}
