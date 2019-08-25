package 啊哈算法_学习笔记;

import java.util.Scanner;

public class 炸弹人_上下左右直走遍历 {
	/*
输入：
	 13 13
#############
#GG.GGG#GGG.#
###.#G#G#G#G#
#.......#..G#
#G#.###.#G#G#
#GG.GGG.#.GG#
#G#.#G#.#.###
##G...G.....#
#G#.#G###.#G#
#...G#GGG.GG#
#G#.#G#G#.#G#
#GG.GGG#G.GG#
#############

输出：
	在位置：(9,9)处。最多消灭8个敌人
	  */
	public static void main(String[] args) {
		char a[][]=new char[20][20];
		int sum=0,map=0,p=0,q=0,x,y,m,n;
		Scanner in=new Scanner(System.in);
		n=in.nextInt();	//字符行数
		m=in.nextInt();	//一行字符中的列数
		String temp="";
		for(int i=0;i<n;i++){	//输入字符串，然后把字符串转化为字符数组
			temp=in.next();
			for(int j=0;j<m;j++)
				a[i][j]=temp.charAt(j);
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(a[i][j]=='.'){	//先判断这个点是不是平地，是平地才可放炸弹
					sum=0;	//用来统计可以消灭的敌人数，每次统计前都要初始化为0
					
					//向左直走遍历
					x=i;	y=j;	//把i和j放在x和y中，用x和y来遍历
					while(a[x][y]!='#'){	//判断是不是墙，不是墙就继续
						if('G'==a[x][y])
							sum++;
						x--;
					}
					
					//向右直走遍历
					x=i;	y=j;	//把i和j放在x和y中，用x和y来遍历
					while(a[x][y]!='#'){	//判断是不是墙，不是墙就继续
						if('G'==a[x][y])
							sum++;
						x++;
					}
					
					//向上直走遍历
					x=i;	y=j;	//把i和j放在x和y中，用x和y来遍历
					while(a[x][y]!='#'){	//判断是不是墙，不是墙就继续
						if('G'==a[x][y])
							sum++;
						y--;
					}
					
					//向下直走遍历
					x=i;	y=j;	//把i和j放在x和y中，用x和y来遍历
					while(a[x][y]!='#'){	//判断是不是墙，不是墙就继续
						if('G'==a[x][y])
							sum++;
						y++;
					}
					
					if(sum>map){	//更新map中的最大值
						map=sum;
						p=i;q=j;	//p和q记录当前坐标
					}
				}
			}
		}
		System.out.println("在位置：("+p+","+q+")处。最多消灭"+map+"个敌人");
	}
}
