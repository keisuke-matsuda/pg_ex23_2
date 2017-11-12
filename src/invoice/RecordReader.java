package invoice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import service.Record;

public class RecordReader {

	private BufferedReader reader;

	public RecordReader() throws FileNotFoundException {
		this(new FileReader(new File(Main.recordfile)));
	}


	public RecordReader(Reader reader) {
		this.reader = new BufferedReader(reader);
	}

	public Record read() throws IOException {
		String line = this.reader.readLine();
		if(line == null){
			return null;
		}
		return new Record(line);
	}

	public void close() throws IOException {
		this.reader.close();
	}

}
