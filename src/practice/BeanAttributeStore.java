package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.Properties;

public class BeanAttributeStore {
	private String outputFilePath;

	public String getOutputFilePath() {
		return outputFilePath;
	}

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	public void store(Object object) throws FileNotFoundException {
		Properties properties = new Properties();
		Class<?> clazz = object.getClass();
		fieldValueExtact(object, clazz, properties);
		OutputStream stream = new FileOutputStream(new File(outputFilePath + "/" + fileName));
		Writer writer = new OutputStreamWriter(stream, Charset.forName("UTF-8"));

		try {
			properties.store(writer, "UTF-8");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 属性值抽取器
	 **/
	private void fieldValueExtact(Object object, Class<?> clazz, Properties properties) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				properties.setProperty(field.getName(), field.get(object).toString());
				System.out.println(field.getName() + "---" + field.get(object).toString());
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		clazz = clazz.getSuperclass();
		if (clazz != null) {
			fieldValueExtact(object, clazz, properties);
		}
	}
}
