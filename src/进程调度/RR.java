package ���̵���;

import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.Date;  
import java.util.List;  
import java.util.concurrent.ArrayBlockingQueue;  
  
/** 
 * ʱ��Ƭ��ת�����㷨 
 */  
public class RR {  
  
    private  static SimpleDateFormat tm= new SimpleDateFormat("HH:mm:ss");  
    private  static  int task_num=3;  
    private  static  int Circle_size=4;//����ʱ��Ƭ��С  
    public  static  ArrayBlockingQueue task_q=new ArrayBlockingQueue(task_num);//���̶���  
    private  static  List<double[]> execute_time=new ArrayList<double[]>();//����ִ��ʱ��  
  
    public  static  void CircleTime()  
    {  
        try {  
            while (true) {  
                double[] t = new double[4];  
                t = (double[])task_q.take();  
                int current_task_time=(int)t[3];  
                int task_NO=(int)t[0];  
                System.out.print(tm.format(new Date())+"��" +task_NO+"�Ž��̿�ʼ����====");  
                if(current_task_time<=Circle_size)//����ܹ��ڱ�ʱ��Ƭ���������  
                {  
                    Thread.sleep((long) current_task_time*1000);//ģ����������ʱ��  
                    System.out.println(tm.format(new Date())+"����ִ��=====������ʱ"+current_task_time+"S");  
                    double[] exe_t=new double[2];  
                    exe_t[0]=task_NO;  
                    exe_t[1]=System.currentTimeMillis()-t[1];//����ý������õ���תʱ��  
                    execute_time.add(exe_t);//���뵽��תʱ�����  
                }  
                else {//��������ٱ���ʱ��Ƭ��������  
                    t[3]=t[3]-Circle_size;  
                    task_q.put(t);  
                    Thread.sleep(Circle_size*1000);  
                    System.out.println(tm.format(new Date())+"����ʱ��Ƭ����~~~~~���̵ȴ�");  
                }  
                if(task_q.size()==0)//������̶���Ϊ���ˣ����˳�ѭ��  
                    break;  
            }  
        }  
        catch (Exception e)  {  
        }  
        show_time();//��ʾÿ�����̵ĵ���ʱ��  
    }  
    public static  void show_time()//��ʾÿ�����̵ĵ���ʱ��  
    {  
        double sum_time=0;  
        for(int i=0;i<execute_time.size();i++)  
        {  
            double[] t=execute_time.get(i);  
            System.out.println("task:"+t[0]+":��תʱ��="+(int)(t[1]/1000)+"S");  
            sum_time+=t[1];  
        }  
        System.out.println("ʹ��ʱ��Ƭ��ת�Ĳ��ԣ�ƽ����תʱ��Ϊ��"+(int)(sum_time/execute_time.size()/1000)+"S");  
    }  
    static void init_task(List<double []> in,int tn)//��ʼ�������б�  
    {  
        task_num=tn;  
        for(int i=0;i<task_num;i++)  {  
            double [] t=in.get(i);  
            t[1] = System.currentTimeMillis();//��ý��̵���ʱ��  
            try {  
                task_q.put(t);  
            } 
            catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
  
        }  
    }  
}  
