package practice;

import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.FileSystem;
import java.util.Arrays;

public class JWzw {
	// 插入排序 { 8, 89, 5, 84, 3, 45, 12, 33, 77, 98, 456, 878, 654, 213,
	public void insertArray(Integer[] in) {
		int tem = 0;
		int num = 0;
		int upnum = 0;
		for (int i = 0; i < in.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				num++;
				if (in[j + 1] < in[j]) {
					tem = in[j + 1];
					in[j + 1] = in[j];
					in[j] = tem;
					upnum++;
				} else {
					break;
				}
			}
		}
		for (int i = 0; i < in.length; i++) {
			System.out.print(in[i]);
			if (i < in.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
		System.out.println("插入排序循环次数:" + num);
		System.out.println("移动次数：" + upnum);
		System.out.print("\n\n\n");
	}

	// 选择排序
	public void chooseArray(Integer[] array) {
		int tem = 0;
		int num = 0;
		int upnum = 0;

	    int minIndex=0;
	    int temp=0;
	    if((array==null)||(array.length==0))
	        return;
	    for(int i=0;i<array.length;i++)
	    {
	        minIndex=i;//无序区的最小数据数组下标
	        for(int  j=i+1;j<array.length;j++)
	        {
	            //在无序区中找到最小数据并保存其数组下标
	            if(array[j]<array[minIndex])
	            {
	                minIndex=j;
	            }
	        }
	        //将最小元素放到本次循环的前端
	        temp=array[i];
	        array[i]=array[minIndex];
	        array[minIndex]=temp;
	    }
		System.out.println(Arrays.toString(array)+"选择排序循环次数:" + num+"移动次数：" + upnum);
	}

	/**
	 *
	 *
	 * 
	 * 
	 * int tem = 0; int num = 0; int upnum = 0; for (int i = 0; i < in.length; i++)
	 * { for (int j = i; j < in.length - 1; j++) { num++; if (in[j + 1] < in[i]) {
	 * tem = in[j + 1]; in[j + 1] = in[i]; in[i] = tem; upnum++; } } } for (int i =
	 * 0; i < in.length; i++) { System.out.print(in[i]); if (i < in.length - 1) {
	 * System.out.print(","); } } System.out.println();
	 * System.out.println("冒泡排序循环次数:" + num); System.out.println("移动次数：" + upnum);
	 * System.out.print("\n\n\n");
	 * 
	 */

	// 冒泡排序 { 8, 89, 5, 84, 3, 45, 12, 33, 77, 98, 456, 878, 654, 213,
	// 897,-1,-2,-2,1000 };
	public void efferArray(Integer[] in) {
		int count = 0;
		int move = 0;
		for (int i = 0; i < in.length; i++) {
			count++;
			for (int j = 0; j < in.length - 1 - i; j++) {
				if (in[j] > in[j + 1]) {
					int temp = in[j];
					in[j] = in[j + 1];
					in[j + 1] = temp;
					move++;
				}
			}
		}
		System.out.println(Arrays.toString(in) + "趟：" + count + "移动" + move);
	}

	public void efferArray2(Integer[] in) {
		int count = 0;
		int move = 0;
		for (int i = 0; i < in.length; i++) {
			count++;
			for (int j = i; j < in.length - 1; j++) {
				if (in[j + 1] < in[i]) {
					int tem = in[j + 1];
					in[j + 1] = in[i];
					in[i] = tem;
					move++;
				}
			}
		}
		System.out.println(Arrays.toString(in) + "趟：" + count + "移动" + move);
	}

	// 打印 N* 1 + N * 2 + N * 3 =num的所有组合
	public void printNumAssemble(int num) {
		for (int i = 0; i < num + 1; i++) {
			for (int j = 0; j < num - i + 1; j++) {
				for (int in = 0; in < num - i - j + 1; in++) {
					if (i * 1 + j * 2 + in * 3 == num) {
						// System.out.println("小马" + i + ",\t中马" + j + ",\t大马" + in);
						int[] result = (int[]) Array.newInstance(int.class, 3);
						result[0] = i;
						result[1] = j;
						result[2] = in;
						System.out.println(Arrays.toString(result));
					}
				}
			}
		}
	}

	/**
	 *  * @param args  
	 */
	public static void main(String[] args) {
	    
		JWzw jwzw = new JWzw();
		//jwzw.printNumAssemble(5); // 打印N * 1 + N * 2 + N * 3 =num的所有组合
		Integer in[] = { 8, 89, 5, 84, 3, 45, 12, 33, 77, 98, 456, 878, 654, 213, 897};
		jwzw.efferArray(in.clone()); // 冒泡排序
		jwzw.efferArray2(in.clone());
		Integer in1[] = { 8, 89, 5, 84, 3, 45, 12, 33, 77, 98, 456, 878, 654, 213, 897 };
		jwzw.insertArray(in1); // 插入排序
		Integer in2[] = { 8, 89, 5, 84, 3, 45, 12, 33, 77, 98, 456, 878, 654, 213, 897 };
		jwzw.chooseArray(in2); // 选择排序
	}
}