package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class FieldValueLoader {
	private String loadPath;
	private String fileName;

	public String getLoadPath() {
		return loadPath;
	}

	public FieldValueLoader() {
		initWrap();
	}

	public void setLoadPath(String loadPath) {
		this.loadPath = loadPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private Properties load() {
		File file = new File(loadPath + "/" + fileName);
		Properties properties = new Properties();
		try {
			Reader reader = new InputStreamReader(new FileInputStream(file));
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	private Properties properties;

	public Object fitOut(Object object) {
		properties = load();

		return obtainfields(object, object.getClass(), properties);

	}

	/**
	 * 属性值抽取器
	 **/
	private Object obtainfields(Object object, Class<?> clazz, Properties properties) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				if (properties.containsKey(field.getName())) {
					Object value = properties.get(field.getName());
					Class<?> fIeldTypeClass = field.getType();
					if (fIeldTypeClass.isPrimitive()) {
						fIeldTypeClass = getwrapClassByFild(fIeldTypeClass);
					}
					Constructor<?> constructor = fIeldTypeClass
							.getConstructor(String.class);
					if (constructor != null) {
						field.set(object, constructor.newInstance(value));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		clazz = clazz.getSuperclass();
		if (clazz != null) {
			obtainfields(object, clazz, properties);
		}
		return object;
	}

	private Map<String, Class<?>> wrapClassMap;

	private void initWrap() {
		wrapClassMap = new HashMap<>();
		wrapClassMap.put("int", Integer.class);
		wrapClassMap.put("boolean", Boolean.class);
		wrapClassMap.put("byte", Byte.class);
		wrapClassMap.put("float", Float.class);
		wrapClassMap.put("double", Double.class);
		wrapClassMap.put("char", Character.class);
		wrapClassMap.put("long", Long.class);
		wrapClassMap.put("short", Short.class);
		wrapClassMap.put("void", Void.class);
	}

	private Class<?> getwrapClassByFild(Class<?> clazz) {
		if (clazz.getName().equals("void") || clazz == Void.class) {
			return null;
		}
		for (Iterator<String> iterator = wrapClassMap.keySet().iterator(); iterator.hasNext();) {
			String item = (String) iterator.next();
			if (clazz.getName().equals(item) || clazz.equals(wrapClassMap.get(item))) {
				return wrapClassMap.get(item);
			}
		}
		return clazz;
	}

	private boolean isWrapClass(Class<?> clazz) {
		for (Iterator<String> iterator = wrapClassMap.keySet().iterator(); iterator.hasNext();) {
			String item = (String) iterator.next();
			if (clazz.equals(wrapClassMap.get(item))) {
				return true;
			}
		}
		return false;
	}
}
