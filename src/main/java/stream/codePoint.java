package stream;

/***
 * 
 * 鐮佺偣锛� 
 * 
 * ****/
public class codePoint {

	public static void main(String[] args) {
		String a="abc\r\n";
		String b="abc\r\n";
		String c=new String("abc");
		String d=new String("abc");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(c.hashCode());
		System.out.println(d.hashCode());
		System.out.println(a==b);
		System.out.println(b==c);
		System.out.println(d==c);
		System.out.println(b.equals(c));
		System.out.print(b);
		System.out.print(b);
	
		
	}
	
	
	
}
