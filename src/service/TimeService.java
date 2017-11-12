package service;

abstract class TimeService implements Service {

	private boolean joined = false;

	public void clear() {
		joined = false;
	}

	public void joined() {
		joined = true;
	}

	public boolean isJoined() {
		return joined;
	}

	// 割引サービスに加入しているかを検査する
	public void checkService(Record record) {
		if (getServiceCode().equals(record.getServiceCode())) {
			joined();
		}
	}

	public abstract boolean isServiceTime(int hour);

	public abstract String getServiceCode();

	// 単価を計算する
	public int calcUnitPrice(Record record, int unitPrice) {
		int hour = record.getStartHour();
		if (isServiceTime(hour)) {
			// 割引
			unitPrice -= getDiscount();
		}
		return unitPrice;
	}

	public abstract int getDiscount();

	//	基本料金を計算する
	public int calcBasicCharge(int basicCharge) {
		if (isJoined()) {
			basicCharge += getBasicCharge();
		}
		return basicCharge;
	}

	public abstract int getBasicCharge();

}
