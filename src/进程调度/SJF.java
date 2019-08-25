package ���̵���;

import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.Date;  
import java.util.List;  
  
/** 
 * ���ʱ�������㷨 
 */  
public class SJF {  
  
    private static int task_num = 3;  //������������
    public static List<double[]> task_time = new ArrayList<double[]>();  //��������ʱ��
   // private static SimpleDateFormat df = new SimpleDateFormat("HHmmss");  
    private static SimpleDateFormat tm = new SimpleDateFormat("HH:mm:ss");  //��������ʱ���ʽ
    private static List<double[]> execute_time = new ArrayList<double[]>();  //��������ִ��ʱ��
    
    static void init_task(List<double[]> task_info, int tn) {  
        task_num = tn;  
        for (int i = 0; i < task_num; i++) {  
            double[] t = task_info.get(i);  
            t[1] = System.currentTimeMillis();  //��ȡ��ǰϵͳʱ��
            task_time.add(t);  
        }  
    }  
    public  static void show_time(){  
        double sum_time=0;  
        for(int i=0;i<execute_time.size();i++){  
            double[] t=execute_time.get(i);  
            System.out.println("task:"+t[0]+":��תʱ��="+(int)(t[1]/1000)+"S");  
            sum_time+=t[1];  
        }  
        System.out.println("ʹ�������ҵ���ȵĲ��ԣ�ƽ����תʱ��Ϊ��"+(int)(sum_time/execute_time.size()/1000)+"S");  
    }  
    public static double[] get_task(List<double[]> task_time) {  
        double[] rt = new double[4];  
        double smallest_time = 50;  
  
        int t = -1;  
        for (int i = 0; i < task_time.size(); i++) {  
            if (task_time.get(i)[3] < smallest_time) {  
                smallest_time = task_time.get(i)[3];  
                t = i;  
            }  
        }  
        rt = task_time.get(t);  
        task_time.remove(t);  
        return rt;  
    }
    
    public static void SJF() {  
        for (int i = 0; i < task_num; i++) {  //��������������������try catch���
            try {  
                double[] t = get_task(task_time);  
                int current_task_time = (int) t[3];  
                int task_NO = (int) t[0];  
                System.out.print(tm.format(new Date()) + "��" + task_NO + "�Ž��̿�ʼִ��====");  //��ʾĳ���߳̿�ʼ��ʱ��
  
                Thread.sleep(1000 * current_task_time);  //���߳����߸�ָ��ʱ��
                System.out.println("  " + tm.format(new Date()) + "ִ�����=====��ʱΪ" + current_task_time + "S");  
  
                double exe_time =System.currentTimeMillis() - t[1];  
                double[] e = new double[2];  
                e[0] = task_NO;  
                e[1] = exe_time;  
                execute_time.add(e);  
           } 
           catch (InterruptedException e) {  
        	   e.printStackTrace();  
           }  
        }  
       show_time();  
    }  
}  

