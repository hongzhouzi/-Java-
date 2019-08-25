package practice;

//import java.util.Comparator;
//import java.util.List;
//import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;

public class 最小乘积_基本型 {
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		for(int i=0;i<n;i++){	//输入数据
			int T=in.nextInt();
//			int[] arr1 = new int[T];
//			int[] arr2 = new int[T];
			Integer[] arr1=new Integer[T];		//如果用降序排列就需要这样写
			Integer[] arr2=new Integer[T];
			for(int j = 0; j < T; j ++) {
			    arr1[j] = in.nextInt();
			}
			for(int j = 0; j < T; j ++) {
				arr2[j] = in.nextInt();
			}
			Arrays.sort(arr1);
			Arrays.sort(arr2,Collections.reverseOrder());	//降序排序
//			Arrays.sort(arr2);								//升序排序
			Integer sum = 0;
            for(int k = 0; k < T; k ++) {
            	sum += (arr1[k] * arr2[k]);
//              sum += (arr1[k] * arr2[T - k - 1]);		//如果排序处用升序排序，那么相乘时就错位相乘
            }
          System.out.println(sum);
        }
      in.close();
	}			
}
/*
注意，要想改变默认的排列顺序，不能使用基本类型（int,double, char）
而要使用它们对应的类
	Arrays.sort(a, Collections.reverseOrder());
	将按照逆字典（字母）顺序对数组进行排序
Comparator是一个接口
Comparator是一个比较器
Comparator中的compare可以将传入进行比对，按照返回的参数大于(1)等于(0)小于(-1)进行排序
默认情况下返回1的在后，返回-1的在前
如果我们需要逆序，只要把返回值-1和1的换位置即可。*/

//Comparator cmp = new MyComparator();
//Arrays.sort(arr2, cmp);

//class MyComparator implements Comparator<Integer> {
//	public int compare(Integer o1, Integer o2) {
//	         // 如果o1小于o2，我们就返回正值，如果n1大于n2我们就返回负值，
//	    if (o1 < o2) {
//	             return 1;
//	    } else if (o1 > o2) {
//             return -1;
//        } else {
//            return 0;
//        }
//    }
//}
