package ����;

public class _8_ֽ�������� {
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
			
		}System.out.println(count/2/3);	//��Ϊ��ת�����һ�֣�����Ҫ��3����Ϊ������Ҳ��һ�֣����Ի�Ҫ����2
	}
}
/*2�����⣺ֽ��������
        A,2,3,4,5,6,7,8,9 ��9��ֽ���ų�һ���������Σ�A��1���㣩��Ҫ��ÿ���ߵĺ���ȡ�
        ��ͼ����һ���ŷ������ж������⣬�ο�p1.png����

              A
             9 6
            4   8
           3 7 5 2

        �������ŷ����ܻ��кܶࡣ

        ���������ת���������ͬ����ͬһ�֣�һ���ж����ֲ�ͬ���ŷ��أ�

        ������㲢�ύ�����֡�

        ע�⣺��Ҫ�ύ����һ����������Ҫ�ύ�κζ������ݡ�

����ûʲô��˵�ģ���ǰд���˱���ö��ģ�壬ֱ����

�𰸣�144*/