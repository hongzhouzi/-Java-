package practice;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ���ʽ����{
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();  //ջ
        String s=sc.nextLine();  //��ȡһ������
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);  //����ȡ�ַ�
            if(c==')')
            {
                LinkedList list = new LinkedList();  //����
                String s2;
                while(!(s2=stack.pop().toString()).equals("(")){
                    list.addFirst(s2);
                }
                stack.push(f(list));  //��f(list)��ջ
            }
            else{
                //�Ƿ���
                if(c<'0')
                {
                    stack.push(c);
                }
                //������
                else
                {
                    int j=i;
                    StringBuilder sb = new StringBuilder(); //�ɱ��ַ���
                    //ֻҪ��ǰ�ַ������֣��Ͱѵ�ǰ�ַ�׷�ӵ�stringbuilder��
                    //���whileѭ����Ŀ���Ƕ�ȡһ����ֹһλ�������ݴ���stringbuilder��
                    while(c>='0'){
                        sb.append(c);
                        //�õ�ǰ�ַ�ָ����ʽ�е���һ���ַ�
                        j++;
                        //���ָ����һ���ַ����Ѿ����˱��ʽ�Ľ�β�ˣ��ͽ���whileѭ��
                        if(j==s.length())
                            break;
                        //���µ�ǰ������ַ�
                        c=s.charAt(j);
                        //��һ��whileѭ��ʱ���ж���ָ�����һ���ַ��ǲ������֣���������֣����ظ����ϲ���
                        //����������������whileѭ��
                    }
                    //i����ָ�������Ǹ���λ���ֵ����һ�������ַ�����Ϊ���for��ȥִ��i++����
                    //�������forѭ����i++���Ӧ������Ǵ����һ����λ�ַ������֣�for�е�i++�Ժ�һ��ָ���Ӧ���Ƿ�����
                    i=j-1;
                    //���ղŶ���������ת��������Ȼ����ջ
                    stack.push(Integer.parseInt(sb.toString()));
                }
            }
        }
        LinkedList list = new LinkedList();
        while(!stack.isEmpty())
            list.addFirst(stack.pop());
        System.out.println(f(list));

    }

    private static Object f(LinkedList list) {
        LinkedList list2 = new LinkedList();
        //��һ��while���������е����г˳���
        while(!list.isEmpty()){
            String s=list.poll().toString();
            if(s.equals("*")||s.equals("/")){
                int a=Integer.parseInt(list2.pollLast().toString());
                int b=Integer.parseInt(list.pop().toString());
                if(s.equals("*"))
                    list2.addLast(a*b);
                else
                    list2.add(a/b);
            }else{
                list2.add(s);
            }
        }
        
        //�ڶ���while�������������мӼ���
        while(list2.size()!=1){
            //��ȡ��һ��������
            int a=Integer.parseInt(list2.poll().toString());
            //��ȡ������
            String s2=list2.poll().toString();
            //��ȡ�ڶ���������
            int b=Integer.parseInt(list2.poll().toString());
            
            if(s2.equals("+")){
                list2.addFirst(a+b);
            }else{
                list2.addFirst(a-b);
            }
        }
        return list2.getFirst();
    }
}
