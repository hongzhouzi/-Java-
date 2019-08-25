package 进程调度;

import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * 用于生成随机的进程列表，并测试三种不同的调度算法 
 */  
public class Process {  
  
    public static List<double []> task_info=new ArrayList<double[]>();//进程列表  ，用可变数组表示
    public static  int task_num=3;//进程数8个，静态全局变量
    public static  void init_task()//初始化进程列表  
    {  
        for(int i=0;i<task_num;i++)  
        {  
            double[] t=new double[4];  
            t[0]=i;//进程号  
            t[1]=0;//到达时间  
            t[2]=0;//响应比  
            t[3]=(int)(Math.random()*100)%20+1;//随机生成需要运行时间  ，范围在1到20之间
            task_info.add(t);  
        }  
    } 
    public static void main(String arg[])  
    {  
        Process.init_task();//初始化进程列表  
  
        System.out.println("最短作业优先================================================");  
        SJF.init_task(task_info,task_num);  
        SJF.SJF();//最短作业优先  
  
        System.out.println("\n\n最高响应比================================================");  
        HRRN.init_task(task_info,task_num);  
        HRRN.HRRN();//高相应比  
  
        System.out.println("\n\n时间片轮转================================================");  
        RR.init_task(task_info,task_num);  
        RR.CircleTime();//时间片轮转  
    }  
}  
