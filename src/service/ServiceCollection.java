package service;

public class ServiceCollection implements Service {

	private Service[] services = { new DayService(), new FamilyService() };

	public void clear() {
		services[0].clear();
		services[1].clear();
	}

	public void checkService(Record record) {
		services[0].checkService(record);
		services[1].checkService(record);

	}

	public int calcUnitPrice(Record record, int unitPrice) {
		int calcedUnitPrice;
		calcedUnitPrice = services[0].calcUnitPrice(record, unitPrice);
		calcedUnitPrice = services[1].calcUnitPrice(record, calcedUnitPrice);
		return calcedUnitPrice;
	}

	public int calcBasicCharge(int basicCharge) {
		int calcedBasicCharge;
		calcedBasicCharge = services[0].calcBasicCharge(basicCharge);
		calcedBasicCharge = services[1].calcBasicCharge(calcedBasicCharge);
		return calcedBasicCharge;
	}

}
