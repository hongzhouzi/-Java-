package acm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
	static String name[]={"Kanbara Akihito","Kuriyama Mirai","Nase Hiroomi","Nase Mitsuki"};
	static int nameNum=name.length;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String nameCh[]=new String[10000];
		int n=in.nextInt();
		for(int i=0;i<n;i++){	//��ȡ����Ĳ��������ַ�
			nameCh[i]=in.next();
			List ansnamList=doCreate(nameCh[i]);
			System.out.println(ansnamList.size());
			for(int j=0;j<ansnamList.size();j++){
				System.out.println(ansnamList.get(j));
			}
		}
		
		/*for(int i=0;i<n;i++){
			List ansnamList=doCreate(nameCh[i]);
			System.out.println(ansnamList.size());
			for(int j=0;j<ansnamList.size();j++){
				System.out.println(ansnamList.get(j));
			}
		}*/
	}
	static List<String> doCreate(String strNameCh){
		List<String> ansNameList=new ArrayList<String>();
		
		for(int i=0;i<nameNum;i++){		//name��ĸ���
			if(strNameCh.length()>name[i].length()){
				continue;
			}
			int searchIndex=0;
			for(int j=0;j<strNameCh.length();j++){		//ѭ��nameChar��
		
				if(index(name[i], strNameCh.charAt(j), searchIndex)>-1){	//˵���ܹ��ҵ�
					searchIndex=index(name[i], strNameCh.charAt(j), searchIndex)+1;//֮����ҵ��ַ������Եĺ�������
				}
				else{	//�����ҵ�������ѭ�������ж���һ�����ֵ�ƥ��
					searchIndex=-1;
					break;
				}
			}
			if(searchIndex >= 0 && searchIndex <= name[i].length()){	//ע��ȡֵ��Χ
				ansNameList.add(name[i]);
			}
		}
		
		return ansNameList;
	}
	static int index(String s,char ch,int start){
		return s.indexOf(ch, start);
	}
}
