package service;

public class DayService extends TimeService {

	private static final int START_TIME = 8;
	private static final int END_TIME = 17;
	private static final String SERVICE_CODE = "E1";
	private static final int BASIC_CHARGE = 200;
	private static final int DISCOUNT_PERMIN = 5;

	public boolean isServiceTime(int hour) {
		if (isJoined() && START_TIME <= hour && hour <= END_TIME) {
			return true;
		}
		return false;
	}

	public String getServiceCode() {
		return SERVICE_CODE;
	}

	public int getDiscount() {
		return DISCOUNT_PERMIN;
	}

	public int getBasicCharge() {
		return BASIC_CHARGE;
	}

}
