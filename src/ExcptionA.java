import org.junit.jupiter.api.Test;

public class ExcptionA {
       
	
	@Test
	public void excpetion() {
		try {
		throw new Throwable();
		}catch (Throwable e) {
			// TODO: handle exception
			System.out.println("1111111");
		}finally {
			System.out.println("22222222");
			
		}
	}

	
	public static void main(String[] args) {
		System.out.println("dsadasdasdsad");
	}
	
	
	
}
