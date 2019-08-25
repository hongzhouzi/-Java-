package leetCode;

import java.util.ArrayList;
import java.util.List;
/*
 * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
会有多少车队到达目的地?

示例：
输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
输出：3
解释：
从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。

提示：
0 <= N <= 10 ^ 4
0 < target <= 10 ^ 6
0 < speed[i] <= 10 ^ 6
0 <= position[i] < target
所有车的初始位置各不相同。*/
public class 车队 {
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
        for(int i=0;i<lenP;i++){	//计算出距离和时间
        	distance[i]=target-position[i];
        	time[i]=(float)distance[i] / (float)speed[i];
        }
        //按距离排序时间，距离远的在最后面
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
        boolean flag=false;	//判断是否连续小于用
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
