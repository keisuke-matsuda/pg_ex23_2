package invoice;

import java.io.FileWriter;
import java.io.IOException;

import service.Record;
import service.Service;
import service.ServiceCollection;

public class Main {

	private static final int INITIAL_BASIC_CHARGE = 1000;
	private static final int INITIAL_CALL_UNIT_PRICE = 20;
	private static final char RC_OWNER_INFO = '1';
	private static final char RC_SERVICE_INFO = '2';
	private static final char RC_CALL_LOG = '5';
	private static final char RC_SEPARATOR = '9';

	static String invoicefile = "file/invoice.dat";
	static String recordfile = "file/record.log";

	public static void main(String[] args) throws IOException {
		int basicCharge = 0;
		int unitPrice = 0;
		int callCharge = 0;
		String invoicefile = "file/invoice.dat";

		Service service = new ServiceCollection();
		RecordReader reader = new RecordReader();
		InvoiceWriter writer = new InvoiceWriter(new FileWriter(invoicefile));
		Invoice invoice = new Invoice();

		for (Record record = reader.read(); record != null; record = reader.read()) {
			char recordCode = record.getRecordCode();

			switch (recordCode) {
			case RC_OWNER_INFO:
				invoice.setOwnerTelNumber(record.getOwnerTelNumber());
				basicCharge = INITIAL_BASIC_CHARGE;
				unitPrice = INITIAL_CALL_UNIT_PRICE;
				break;
			case RC_SERVICE_INFO:
				service(service, record);
				service.checkService(record);
				break;
			case RC_CALL_LOG:
				call(invoice, service, record);
				unitPrice = service.calcUnitPrice(record, unitPrice);
				callCharge += (unitPrice * record.getCallMinutes());
				invoice.addCallCharge(callCharge);
				callCharge = 0;
				unitPrice = INITIAL_CALL_UNIT_PRICE;
				break;
			case RC_SEPARATOR:
				separate(invoice, service, writer);
				basicCharge = service.calcBasicCharge(basicCharge);
				invoice.setBasicCharge(basicCharge);
				writer.write(invoice);
				invoice.clear();
				service.clear();
				break;
			}

		}
		reader.close();
		writer.close();

	}

	private static void service(Service service, Record record) {

	}

	private static void call(Invoice invoice, Service service, Record record) {

	}

	private static void separate(Invoice invoice, Service service, InvoiceWriter writer) {

	}

}
