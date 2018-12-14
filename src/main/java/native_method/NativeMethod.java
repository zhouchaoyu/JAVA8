package native_method;
public class NativeMethod {

	 public static void main(String[] args)
	    { 
          	
		
		    System.loadLibrary("Tool"); 
	        NativeMethodLoader nmt = new NativeMethodLoader();
	        Double double1 = Double.valueOf(args[0]);
	        Double double2 = Double.valueOf(args[1]);
	        System.out.println(double1+"----------------"+double2);
	        double add = nmt.Add(double1,double2);
	        System.out.println(add);
	        
	    }
	

	static class NativeMethodLoader
	{   
	   public native double Add(double x,double y);
	}
	
}
