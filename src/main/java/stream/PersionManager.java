package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PersionManager {

	public void writePersions(List<Persion> persions, OutputStream out) {

	}

	@SuppressWarnings("resource")
	public void writePersions(List<Persion> persions, String path) throws IOException {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
			for (Iterator<Persion> iterator = persions.iterator(); iterator.hasNext();) {
				Persion persion = (Persion) iterator.next();
				writer.write(persion.getName() + " | " + persion.getNo() + " | " + persion.getSex().toString() + " | "
						+ persion.getBrithyDay().toString() + System.lineSeparator());
				writer.flush();
			}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

	}

	public List<Persion> ReadPersions(InputStream in) {
		return null;

	}

	public List<Persion> ReadPersions(String path) throws IOException {
		ArrayList<Persion> persions = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			String tmp;
			while ((tmp = reader.readLine()) != null) {
				String[] dataArray = tmp.split("\\|");
				if (dataArray.length == 4) {
					Persion persion = new Persion(dataArray[0], Sex.paserToSex(dataArray[2]), dataArray[1],
							new Date(dataArray[3]));
					persions.add(persion);
				} else {
					throw new RuntimeException();
				}
			}
			return persions;
		} finally {
		     if (reader!=null) {
				reader.close();
			}
		}

	}
}
