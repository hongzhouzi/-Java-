package leetCode;

import java.util.ArrayList;
import java.util.List;
/*
 * N  ��������һ������ʻ��λ�� target Ӣ��֮��Ĺ�ͬĿ�ĵء�
ÿ���� i �Ժ㶨���ٶ� speed[i] ��Ӣ��/Сʱ�����ӳ�ʼλ�� position[i] ��Ӣ� �س���ʻ��Ŀ�ĵء�
һ������Զ���ᳬ��ǰ�����һ��������������׷��ȥ������ǰ������ͬ���ٶȽ�������ʻ��
��ʱ�����ǻ������������֮��ľ��룬Ҳ����˵�����Ǳ��ٶ�������ͬ��λ�á�
���� ��һЩ����ʻ����ͬλ�á�������ͬ�ٶȵĳ���ɵķǿռ��ϡ�ע�⣬һ����Ҳ������һ�����ӡ�
����һ������Ŀ�ĵزŸ�����һ�����ӣ�������Ȼ�ᱻ������ͬһ�����ӡ�
���ж��ٳ��ӵ���Ŀ�ĵ�?

ʾ����
���룺target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
�����3
���ͣ�
�� 10 �� 8 ��ʼ�ĳ������һ�����ӣ������� 12 ��������
�� 0 ����ʼ�ĳ��޷�׷�����������������Լ�����һ�����ӡ�
�� 5 �� 3 ��ʼ�ĳ������һ�����ӣ������� 6 ��������
��ע�⣬�ڵ���Ŀ�ĵ�֮ǰû����������������Щ���ӣ����Դ��� 3��

��ʾ��
0 <= N <= 10 ^ 4
0 < target <= 10 ^ 6
0 < speed[i] <= 10 ^ 6
0 <= position[i] < target
���г��ĳ�ʼλ�ø�����ͬ��*/
public class ���� {
	public static void main(String[] args) {
		int target=10;
		int position[]={0,4,2};
		int speed[]={2,1,3};
		System.out.println(carFleet(target, position, speed));
	}
	static int carFleet(int target, int[] position, int[] speed) {
        int count=0,lenP=position.length;
        if(lenP==0) return 0;
        if(lenP==1) return 1;
        int distance[]=new int[lenP];
        float time[]=new float[lenP];
        for(int i=0;i<lenP;i++){	//����������ʱ��
        	distance[i]=target-position[i];
        	time[i]=(float)distance[i] / (float)speed[i];
        }
        //����������ʱ�䣬����Զ���������
        for(int i=0;i<lenP;i++){
        	for(int j=1;j<lenP-i;j++){
        		if(distance[j-1]>distance[j]){
        			int t=distance[j-1];
        			distance[j-1]=distance[j];
        			distance[j]=t;
        			
        			float temp= time[j-1];
        			time[j-1]=time[j];
        			time[j]=temp;
        		}
        	}
        }
        System.out.println("+++++++++++++++++++++++++++++++++++");
        for(int i=0;i<lenP;i++)
        	System.out.println("dis:"+distance[i]+" time:"+time[i]);
        boolean flag=false;	//�ж��Ƿ�����С����
        for(int i=0;i<lenP-1;i++){
        	if(flag){
        		if(time[i]>=time[i+1]){
            		flag=true;
            	}else{
            		count++;
            		flag=false;
            	}
        	}else{
        		if(time[i]>=time[i+1]){
            		flag=true;
            	}else{
            		count++;
            		flag=false;
            	}
        	}
        }
        
        return count;
    }
}
