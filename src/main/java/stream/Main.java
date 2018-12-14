package stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class Main {
	private final PersionManager manager = new PersionManager();
	String path = "psersion.txt";

	//@Test
	public void testRead() {
		try {
			List<Persion> list = manager.ReadPersions(path);
			for (Iterator<Persion> iterator = list.iterator(); iterator.hasNext();) {
				Persion type = (Persion) iterator.next();
				System.out.println(type.toString());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//@Test
	public void testWrite() {
		ArrayList<Persion> pArrayList = new ArrayList<>();
		Persion persion1 = new Persion("xiaowang", Sex.man, "51301155432", new Date(1995, 12, 28));
		Persion persion2 = new Persion("xiaoyu", Sex.man, "51301155432", new Date(1995, 12, 28));
		Persion persion3 = new Persion("xiaonan", Sex.man, "51301155432", new Date(1995, 12, 28));
		pArrayList.add(persion1);
		pArrayList.add(persion2);
		pArrayList.add(persion3);
		try {
			manager.writePersions(pArrayList, path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Test
	public void text() {
		String string = "xiaowang | 51301155432 | 鐢� | Tue Jan 28 00:00:00 CST 3896";
		System.out.println(string.length());
		System.out.println(string.split("\\|").length);
	}

	@Test
	public void name() throws InterruptedException { 
      
	}
	
	
	public static void main(String[] args) {
		Object[] object = { null, null };

		int[] iisss = {};
		int[][] a = {};
		int[][][] b = { null };
		boolean[] c = new boolean[10];
		int[] h[] = new int[10][];
		int[] d[] = new int[10][10];
		int[][] f = { { 10 }, { 10, 10 }, { 10, 10, 10 } };
		System.out.println(c[1]);
	}
}
