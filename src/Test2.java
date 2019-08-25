import java.util.Scanner;

/**
 * 最佳路线顺序是：1,3,5,7,8,6,4,2
 * @author 泓舟
 *
 */
public class Test2 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t1=in.nextInt();//移动1个单位需要的时间
		int t2=in.nextInt();//移动2个单位需要的时间
		int t3=in.nextInt();//移动3个单位需要的时间
		int t_ud_j=in.nextInt();//奇数序列CNC上下所用时间
		int t_ud_o=in.nextInt();//偶数序列CNC上下所用时间
		int t_CNC=in.nextInt();//CNC加工一个一道工序所用时间
		int t_CNC_clear=in.nextInt();//CNC清洗一个一道工序所用时间
		int t_sum1=0;//完成一个循环，上下物料+走的所用时间
		int t_sum=0;//完成循环，以8个小时计算上下物料+走的所用时间
		int i=0;//循环次数
		//int CNC1_t=0,CNC2_t=0,CNC3_t=0,CNC4_t=0,CNC5_t=0,CNC6_t=0,CNC7_t=0,CNC8_t=0;//RGV移动到某台CNC准备上料的时间
		for(i=1;t_sum<=8*60*60;i++){//小于8个小时进行循环，i为循环次数
			t_sum1=0;
			if(1==i)
			{
				//面对填第1个CNC时
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：1"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_j;//填充物料
				t_sum+=t_ud_j;
				
				//面对第3个CNC时
				t_sum1+=t1;//移动
				t_sum+=t1;
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：3"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_j;//填充物料
				t_sum+=t_ud_j;
				
				//面对第5个CNC时
				t_sum1+=t1;//移动
				t_sum+=t1;
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：5"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_j;//填充物料
				t_sum+=t_ud_j;
				
				//填充第7个CNC时，RGV移动时间+填充时间
				t_sum1+=t1;//移动时间
				t_sum+=t1;
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：7"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_j;//填充物料
				t_sum+=t_ud_j;
				
				//填充第8个CNC时，RGV移动时间+填充时间
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：8"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_o;//填充物料
				t_sum+=t_ud_o;
				
				//填充第6个CNC时，RGV移动时间+填充时间
				t_sum1+=t1;
				t_sum+=t1;
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：6"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_o;
				t_sum+=t_ud_o;
				
				//填充第4个CNC时，RGV移动时间+填充时间
				t_sum1+=t1;
				t_sum+=t1;
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：4"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_o;
				t_sum+=t_ud_o;
				
				//填充第2个CNC时，RGV移动时间+填充时间
				t_sum1+=t1;
				t_sum+=t1;
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：2"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_o;
				t_sum+=t_ud_o;
				
				
			}
			else
			{
				//面对填第1个CNC时
				
				
				System.out.println("当前是第"+(i-1)+"次循环,"+",加工CNC编号：1"+"下料开始时间："+t_sum);
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：1"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_j;//填充物料
				t_sum+=t_ud_j;
				t_sum1+=t_CNC_clear;//清洗时间
				t_sum+=t_CNC_clear;
				
				
				//面对第3个CNC时
				t_sum1+=t1;//移动
				t_sum+=t1;
				System.out.println("当前是第"+(i-1)+"次循环,"+",加工CNC编号：3"+"下料开始时间："+t_sum);
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：3"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_j;//填充物料
				t_sum+=t_ud_j;
				t_sum1+=t_CNC_clear;//清洗时间
				t_sum+=t_CNC_clear;
				
				
				//面对第5个CNC时
				t_sum1+=t1;//移动
				t_sum+=t1;
				System.out.println("当前是第"+(i-1)+"次循环,"+",加工CNC编号：5"+"下料开始时间："+t_sum);
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：5"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_j;//填充物料
				t_sum+=t_ud_j;
				t_sum1+=t_CNC_clear;//清洗时间
				t_sum+=t_CNC_clear;
				
				
				//填充第7个CNC时，RGV移动时间+填充时间
				t_sum1+=t1;//移动时间
				t_sum+=t1;
				System.out.println("当前是第"+(i-1)+"次循环,"+",加工CNC编号：7"+"下料开始时间："+t_sum);
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：7"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_j;//填充物料
				t_sum+=t_ud_j;
				t_sum1+=t_CNC_clear;//清洗时间
				t_sum+=t_CNC_clear;
				
				
				//填充第8个CNC时，RGV移动时间+填充时间
				System.out.println("当前是第"+(i-1)+"次循环,"+",加工CNC编号：8"+"下料开始时间："+t_sum);
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：8"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_o;//填充物料
				t_sum+=t_ud_o;
				t_sum1+=t_CNC_clear;//清洗时间
				t_sum+=t_CNC_clear;
				
				
				//填充第6个CNC时，RGV移动时间+填充时间
				t_sum1+=t1;
				t_sum+=t1;
				
				System.out.println("当前是第"+(i-1)+"次循环,"+",加工CNC编号：6"+"下料开始时间："+t_sum);
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：6"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_o;
				t_sum+=t_ud_o;
				t_sum1+=t_CNC_clear;//清洗时间
				t_sum+=t_CNC_clear;
				
				
				//填充第4个CNC时，RGV移动时间+填充时间
				t_sum1+=t1;
				t_sum+=t1;
				System.out.println("当前是第"+(i-1)+"次循环,"+",加工CNC编号：4"+"下料开始时间："+t_sum);
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：4"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_o;
				t_sum+=t_ud_o;
				t_sum1+=t_CNC_clear;//清洗时间
				t_sum+=t_CNC_clear;
				
				
				//填充第2个CNC时，RGV移动时间+填充时间
				t_sum1+=t1;
				t_sum+=t1;
				System.out.println("当前是第"+(i-1)+"次循环,"+",加工CNC编号：2"+"下料开始时间："+t_sum);
				System.out.println("当前是第"+i+"次循环,"+",加工CNC编号：2"+"上料开始时间："+t_sum);
				t_sum1+=t_ud_o;
				t_sum+=t_ud_o;
				t_sum1+=t_CNC_clear;//清洗时间
				t_sum+=t_CNC_clear;
				
				
			}
			
			//RGV等待时间
			int t_RGV_wait=t_CNC+t_ud_j-t_sum1;
			if(t_RGV_wait<0)
				t_RGV_wait=0;
			
			//计算总的时间=走的时间+等待时间
			t_sum+=t_RGV_wait;
			
			//System.out.println("当前是第"+i+"次循环,RGV等待时间："+t_RGV_wait+",完成当前循环所用的时间："+t_sum1+"总的时间："+t_sum);
			
			
		}
		System.out.println("8小时秒数为："+8*3600+"次数："+(i-1));
	}
}
