package practice;

public class BootstrapMain {
	public static void main(String[] args){
	
		/*
		JAVAFactory factory = JAVAFactory.getInstance();
		Teacher teacher = new Teacher();*/
		/*
		teacher.setAge(23);
		teacher.setSex("man");
		teacher.setMerried(false);
		teacher.setProfession("小学教师");
		BeanAttributeStore store = new BeanAttributeStore();
		store.setFileName("Persion.txt");
		store.setOutputFilePath("./res");
		store.store(teacher);*/
		/*
		 * factory.createJava(teacher); factory.setOutputFilePath("./src/lambda"); try {
		 * factory.outputJavaCode(); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		/*FieldValueLoader loader=new FieldValueLoader();
		loader.setFileName("Persion.txt");
		loader.setLoadPath("./res");
		teacher=(Teacher) loader.fitOut(teacher);
		System.out.println(teacher.getProfession());
		System.out.println(teacher.getAge());
		System.out.println(teacher.getName());
		System.out.println(teacher.isMerried());*/
		PersionProxyFactory factory=new PersionProxyFactory();
		PersionSetter persionSetter=factory.getPersion();
		persionSetter.setAge(123);
		
	}

}
