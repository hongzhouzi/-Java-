package practice;

//import java.util.Comparator;
//import java.util.List;
//import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;

public class ��С�˻�_������ {
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		for(int i=0;i<n;i++){	//��������
			int T=in.nextInt();
//			int[] arr1 = new int[T];
//			int[] arr2 = new int[T];
			Integer[] arr1=new Integer[T];		//����ý������о���Ҫ����д
			Integer[] arr2=new Integer[T];
			for(int j = 0; j < T; j ++) {
			    arr1[j] = in.nextInt();
			}
			for(int j = 0; j < T; j ++) {
				arr2[j] = in.nextInt();
			}
			Arrays.sort(arr1);
			Arrays.sort(arr2,Collections.reverseOrder());	//��������
//			Arrays.sort(arr2);								//��������
			Integer sum = 0;
            for(int k = 0; k < T; k ++) {
            	sum += (arr1[k] * arr2[k]);
//              sum += (arr1[k] * arr2[T - k - 1]);		//�������������������ô���ʱ�ʹ�λ���
            }
          System.out.println(sum);
        }
      in.close();
	}			
}
/*
ע�⣬Ҫ��ı�Ĭ�ϵ�����˳�򣬲���ʹ�û������ͣ�int,double, char��
��Ҫʹ�����Ƕ�Ӧ����
	Arrays.sort(a, Collections.reverseOrder());
	���������ֵ䣨��ĸ��˳��������������
Comparator��һ���ӿ�
Comparator��һ���Ƚ���
Comparator�е�compare���Խ�������бȶԣ����շ��صĲ�������(1)����(0)С��(-1)��������
Ĭ������·���1���ں󣬷���-1����ǰ
���������Ҫ����ֻҪ�ѷ���ֵ-1��1�Ļ�λ�ü��ɡ�*/

//Comparator cmp = new MyComparator();
//Arrays.sort(arr2, cmp);

//class MyComparator implements Comparator<Integer> {
//	public int compare(Integer o1, Integer o2) {
//	         // ���o1С��o2�����Ǿͷ�����ֵ�����n1����n2���Ǿͷ��ظ�ֵ��
//	    if (o1 < o2) {
//	             return 1;
//	    } else if (o1 > o2) {
//             return -1;
//        } else {
//            return 0;
//        }
//    }
//}
