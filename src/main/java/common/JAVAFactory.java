package common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
 * 鍒╃敤鍙嶅皠鎶�鏈敓鎴恓ava浠ｇ爜
 * **/
public class JAVAFactory {
	private static JAVAFactory factory;
	
	public static JAVAFactory getInstance() {
		if (factory == null) {
			factory = new JAVAFactory();
		}
		return factory;
	}
	private  Class<?> JavaClass;
	public <T> boolean createJava(Class<T> clazz) {
		JavaClass=clazz;
		return true;
	}
	private StringBuilder javaCode;
	public boolean createJava(Object object) {
		if (object == null) {
			throw new RuntimeException("CreateJavaFile by object can not null ");
		}
		JavaClass = object.getClass();
		JavaBuilder builder=new JavaBuilder(JavaClass);
		javaCode=new StringBuilder(builder.javaBuild());
		System.out.println(javaCode.toString());
		return true;
	}
	private  String  outputFilePath;
	
	
	public String getOutputFilePath() {
		return outputFilePath;
	}

	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}
	
	public  void outputJavaCode() throws Exception{
		if (outputFilePath==null) {
			throw new Exception("outputFilePath  can not null");
		}
		File file=new File(outputFilePath+"/"+JavaClass.getSimpleName()+".java");
		OutputStream outputStream=new FileOutputStream(file);
		if (javaCode.toString().trim().equals("")) {
			throw new RuntimeException("outputJavaCode method is can execute ,this object field 'javaCode' must  can not null or  empty");
		}
		outputStream.write(javaCode.toString().getBytes());
		outputStream.flush();
		outputStream.close();
	}
	
	
	
	
	
	
	
	class JavaBuilder {
		private Class<?> clazz;

		
		private JavaBuilder() {
		}

		public JavaBuilder(Class<?> clazz) {
			this.clazz = clazz;
		}

		private String interfacesBuild(Class<?>[] interfaces) {
			int interfacesSize = 0;
			StringBuilder builder = new StringBuilder();
			if (interfaces.length > 0) {
				interfacesSize = interfaces.length;
				builder.append(" implements ");
			}
			for (int i = 0; i < interfaces.length; i++) {
				if (i == interfacesSize - 1) {
					builder.append(interfaces[i].getCanonicalName());
				} else {
					builder.append(interfaces[i].getCanonicalName() + ",");
				}
			}
			return builder.toString();
		}

		private String SuperClassBuild(Class<?> superClass) {
			StringBuilder builder = new StringBuilder();
			if (superClass != null) {
				builder.append(" extends " + superClass.getCanonicalName());
			}
			return builder.toString();
		}

		private String MethodsBuild(Method[] methods) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < methods.length; i++) {
				builder.append(Modifier.toString(methods[i].getModifiers()));
				builder.append(" ");
				builder.append(methods[i].getReturnType().getName());
				builder.append(" ");
				builder.append(methods[i].getName());
				builder.append("(");
				int methodParaSize = methods[i].getParameterCount();
				Class<?>[] methodPara = methods[i].getParameterTypes();
				for (int j = 0; j < methodPara.length; j++) {
					builder.append(methodPara[j].getName());
					builder.append(" ");
					builder.append(methodPara[j].getSimpleName().toLowerCase());
					if (j != methodParaSize - 1) {
						builder.append(",");
					}

				}
				builder.append(")");
				builder.append("{");
				builder.append("\n");
				builder.append("}");
				builder.append("\n");
			}
			return builder.toString();

		}

		private String ConstructorsBuild(Constructor<?>[] constructors) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < constructors.length; i++) {
				builder.append(Modifier.toString(constructors[i].getModifiers()));
				builder.append(" ");
				String name = constructors[i].getName();
				builder.append(name.substring(name.indexOf(".") + 1, name.length()));
				builder.append("(");
				Class<?>[] methodPara = constructors[i].getParameterTypes();
				int methodParaSize = constructors[i].getParameterCount();
				for (int j = 0; j < methodPara.length; j++) {
					builder.append(methodPara[j].getName());
					builder.append(" ");
					builder.append(methodPara[j].getSimpleName().toLowerCase());
					if (j != methodParaSize - 1) {
						builder.append(",");
					}

				}
				builder.append(")");
				builder.append("{");
				builder.append("\n");
				builder.append("}");
				builder.append("\n");
				
			}
			return builder.toString();
		}

		private String fieldsBuild(Field[] fields) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < fields.length; i++) {
				builder.append(Modifier.toString(fields[i].getModifiers()));
				builder.append(" ");
				builder.append(fields[i].getType().getName());
				builder.append(" ");
				builder.append(fields[i].getName());
				builder.append(";");
				builder.append("\n");
			}
			return builder.toString();
		}

		private String headBuild(Class<?> clazz) {
			StringBuilder builder = new StringBuilder();
			Package packager = clazz.getPackage();
			builder.append(packager);
			builder.append(";");
			builder.append("\n");
			builder.append(Modifier.toString(clazz.getModifiers()));
			builder.append(" class " + clazz.getSimpleName());
			return builder.toString();
		}

		public String javaBuild() {
			StringBuilder builder = new StringBuilder();
			builder.append(headBuild(this.clazz));
			// 鑾峰彇瀹炵幇鐖剁被
			Class<?> superClass = clazz.getSuperclass();
			builder.append(SuperClassBuild(superClass));
			// 鑾峰彇鍏ㄩ儴鎺ュ彛
			Class<?>[] interfaces = clazz.getInterfaces();
			builder.append(interfacesBuild(interfaces));
			builder.append("{\n");
			// 鑾峰彇鍏ㄩ儴瀛楁
			Field[] fields = clazz.getDeclaredFields();
			builder.append(fieldsBuild(fields));
			// 鑾峰彇鏋勯�犳柟娉�
			Constructor<?>[] constructors = clazz.getConstructors();
			builder.append(ConstructorsBuild(constructors));
			// 鑾峰彇鍏ㄩ儴鏂规硶
			Method[] methods = clazz.getDeclaredMethods();
			builder.append(MethodsBuild(methods));
			builder.append("}");
			return builder.toString();
		}
	}
}
