package ���̵���;

import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.Date;  
import java.util.List;  
  
/** 
 *HRRN.java��ģ�������Ӧ�ȵĵ��Ȳ��ԡ�
 */  
public class HRRN {  
    private  static SimpleDateFormat tm= new SimpleDateFormat("HH:mm:ss");  
    public  static List<double []> task_info=new ArrayList<double[]>();//������Ϣ�б�  
    public static  int task_num=3;//������  
    private static List<double[]> execute_time = new ArrayList<double[]>();//������תʱ���б�  
    public static  void HRRN(){  
        for(int i=0;i<task_num;i++)  
        {  
            get_ratio();//ÿ��ѭ��ʱ����һ����Ӧ��  
            double [] tem=get_a_task();//�ӽ����б��еõ�һ�������Ӧ�ȵ�����  
            System.out.print(tm.format(new Date())+"��"+(int)tem[0]+"�Ž��̿�ʼ����====");  
            try {  
                Thread.sleep((long) tem[3]*1000);//ģ�����ִ������Ҫ��ʱ��  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            System.out.println(tm.format(new Date())+"���̽�������=====��ʱΪ"+(int)tem[3]+"S");  
            double[] exe_t=new double[2];  
            exe_t[0]=tem[0];  
            exe_t[1]=System.currentTimeMillis() - tem[1];  
            execute_time.add(exe_t);  
        }  
        show_time();//��ʾÿ�����̵���תʱ��  
    }  
    public  static void show_time()//��ʾÿ�����̵���תʱ��  
    {  
        double sum_time=0;  
        for(int i=0;i<execute_time.size();i++)  
        {  
            double[] t=execute_time.get(i);  
            System.out.println("task:"+t[0]+":��תʱ��="+(int)(t[1]/1000)+"S");  
            sum_time+=t[1];  
        }  
        System.out.println("ʹ�������Ӧ�ȵĲ��ԣ�ƽ����תʱ��Ϊ��"+(int)(sum_time/execute_time.size()/1000)+"S");  
    }  
   public static  double[] get_a_task()//������Ӧ�ȣ�����һ�������Ӧ�Ƚ���  
   {  
       double[]rt=new double[4];  
       double max_ratio=0;  
       int NO=-1;  
       for(int i=0;i<task_info.size();i++)  
       {  
           if(task_info.get(i)[2]>max_ratio)  
           {  
               rt=task_info.get(i);  
               max_ratio=task_info.get(i)[2];  
               NO=i;  
           }  
       }  
       task_info.remove(NO);//���һ�����̱�ѡ�У����ڽ����б���ɾ����  
       return rt;  
   }  
    public static  void init_task(List<double[]> in,int tn)//��ʼ�������б�  
    {  
        task_num=tn;  
        for(int i=0;i<in.size();i++)  
        {  
            double[] t=in.get(i);  
            t[1]=System.currentTimeMillis();//��ý��̵���ʱ��  
            task_info.add(t);  
        }  
    }  
    public static  void  get_ratio()//����ÿһ�����̵�ǰ����Ӧ��  
    {  
        for(int i=0;i<task_info.size();i++)  
        {  
            double[] t=task_info.get(i);  
            task_info.remove(i);  
            double ratio=(System.currentTimeMillis()-t[1])/t[3]+1;//������Ӧ��  
            t[2]=ratio;  
            task_info.add(t);  
        }  
    }  
    public static void main(String arg[])//���ڱ������  
{  
        Process.init_task();  
        init_task(Process.task_info,Process.task_num);  
        HRRN();  
    }  
  
}  

