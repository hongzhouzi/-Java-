package ���̵���;

import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * ������������Ľ����б����������ֲ�ͬ�ĵ����㷨 
 */  
public class Process {  
  
    public static List<double []> task_info=new ArrayList<double[]>();//�����б�  ���ÿɱ������ʾ
    public static  int task_num=3;//������8������̬ȫ�ֱ���
    public static  void init_task()//��ʼ�������б�  
    {  
        for(int i=0;i<task_num;i++)  
        {  
            double[] t=new double[4];  
            t[0]=i;//���̺�  
            t[1]=0;//����ʱ��  
            t[2]=0;//��Ӧ��  
            t[3]=(int)(Math.random()*100)%20+1;//���������Ҫ����ʱ��  ����Χ��1��20֮��
            task_info.add(t);  
        }  
    } 
    public static void main(String arg[])  
    {  
        Process.init_task();//��ʼ�������б�  
  
        System.out.println("�����ҵ����================================================");  
        SJF.init_task(task_info,task_num);  
        SJF.SJF();//�����ҵ����  
  
        System.out.println("\n\n�����Ӧ��================================================");  
        HRRN.init_task(task_info,task_num);  
        HRRN.HRRN();//����Ӧ��  
  
        System.out.println("\n\nʱ��Ƭ��ת================================================");  
        RR.init_task(task_info,task_num);  
        RR.CircleTime();//ʱ��Ƭ��ת  
    }  
}  
