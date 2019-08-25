package 真题;

public class _8_纸牌三角形 {
	public static void main(String[] args) {
		int count=0;
		int box[]=new int[10];
		for(box[1]=1;box[1]<10;box[1]++){
			for(box[2]=1;box[2]<10;box[2]++){
				if(box[1]==box[2]) continue;
				for(box[3]=1;box[3]<10;box[3]++){
					if(box[3]==box[2]||box[1]==box[3]) continue;
					for(box[4]=1;box[4]<10;box[4]++){
						if(box[3]==box[4]||box[1]==box[4]||box[2]==box[4]) continue;
						for(box[5]=1;box[5]<10;box[5]++){
							if(box[5]==box[4]||box[5]==box[3]||box[5]==box[2]||box[5]==box[1]) continue;
							for(box[6]=1;box[6]<10;box[6]++){
								if(box[5]==box[6]||box[6]==box[4]||box[6]==box[3]||box[6]==box[2]||box[6]==box[1]) continue;
								for(box[7]=1;box[7]<10;box[7]++){
									if(box[7]==box[6]||box[7]==box[5]||box[7]==box[4]||box[7]==box[3]||box[7]==box[2]||box[7]==box[1]) continue;
									for(box[8]=1;box[8]<10;box[8]++){
										if(box[8]==box[7]||box[8]==box[6]||box[8]==box[5]||box[8]==box[4]||box[8]==box[3]||box[8]==box[2]||box[8]==box[1]) continue;
										
										for(box[9]=1;box[9]<10;box[9]++){
											if(box[9]==box[8]||box[9]==box[7]||box[9]==box[6]||box[9]==box[5]||box[9]==box[4]||box[9]==box[3]||box[9]==box[2]||box[9]==box[1]) continue;
											
											if(box[1]+box[2]+box[4]+box[6]==box[1]+box[3]+box[5]+box[9]&&box[6]+box[7]+box[8]+box[9]==box[1]+box[3]+box[5]+box[9]){
												System.out.println("1:"+box[1]+" 2:"+box[2]+" 3:"+box[3]+" 4:"+box[1]+" 5:"+box[5]+" 6:"+box[6]+" 7:"+box[7]+" 8:"+box[8]+" 9:"+box[9]);
														count++;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
		}System.out.println(count/2/3);	//因为旋转后的算一种，所以要除3。因为镜像后的也算一种，所以还要除以2
	}
}
/*2，标题：纸牌三角形
        A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
        下图就是一种排法（如有对齐问题，参看p1.png）。

              A
             9 6
            4   8
           3 7 5 2

        这样的排法可能会有很多。

        如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？

        请你计算并提交该数字。

        注意：需要提交的是一个整数，不要提交任何多余内容。

这题没什么好说的，考前写好了暴力枚举模板，直接套

答案：144*/