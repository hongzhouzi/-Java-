package �����㷨_ѧϰ�ʼ�;

import java.util.Scanner;

public class ը����_��������ֱ�߱��� {
	/*
���룺
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

�����
	��λ�ã�(9,9)�����������8������
	  */
	public static void main(String[] args) {
		char a[][]=new char[20][20];
		int sum=0,map=0,p=0,q=0,x,y,m,n;
		Scanner in=new Scanner(System.in);
		n=in.nextInt();	//�ַ�����
		m=in.nextInt();	//һ���ַ��е�����
		String temp="";
		for(int i=0;i<n;i++){	//�����ַ�����Ȼ����ַ���ת��Ϊ�ַ�����
			temp=in.next();
			for(int j=0;j<m;j++)
				a[i][j]=temp.charAt(j);
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(a[i][j]=='.'){	//���ж�������ǲ���ƽ�أ���ƽ�زſɷ�ը��
					sum=0;	//����ͳ�ƿ�������ĵ�������ÿ��ͳ��ǰ��Ҫ��ʼ��Ϊ0
					
					//����ֱ�߱���
					x=i;	y=j;	//��i��j����x��y�У���x��y������
					while(a[x][y]!='#'){	//�ж��ǲ���ǽ������ǽ�ͼ���
						if('G'==a[x][y])
							sum++;
						x--;
					}
					
					//����ֱ�߱���
					x=i;	y=j;	//��i��j����x��y�У���x��y������
					while(a[x][y]!='#'){	//�ж��ǲ���ǽ������ǽ�ͼ���
						if('G'==a[x][y])
							sum++;
						x++;
					}
					
					//����ֱ�߱���
					x=i;	y=j;	//��i��j����x��y�У���x��y������
					while(a[x][y]!='#'){	//�ж��ǲ���ǽ������ǽ�ͼ���
						if('G'==a[x][y])
							sum++;
						y--;
					}
					
					//����ֱ�߱���
					x=i;	y=j;	//��i��j����x��y�У���x��y������
					while(a[x][y]!='#'){	//�ж��ǲ���ǽ������ǽ�ͼ���
						if('G'==a[x][y])
							sum++;
						y++;
					}
					
					if(sum>map){	//����map�е����ֵ
						map=sum;
						p=i;q=j;	//p��q��¼��ǰ����
					}
				}
			}
		}
		System.out.println("��λ�ã�("+p+","+q+")�����������"+map+"������");
	}
}
