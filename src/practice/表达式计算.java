package practice;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class 表达式计算{
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();  //栈
        String s=sc.nextLine();  //读取一行数据
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);  //依次取字符
            if(c==')')
            {
                LinkedList list = new LinkedList();  //链表
                String s2;
                while(!(s2=stack.pop().toString()).equals("(")){
                    list.addFirst(s2);
                }
                stack.push(f(list));  //把f(list)入栈
            }
            else{
                //是符号
                if(c<'0')
                {
                    stack.push(c);
                }
                //是数字
                else
                {
                    int j=i;
                    StringBuilder sb = new StringBuilder(); //可变字符串
                    //只要当前字符是数字，就把当前字符追加到stringbuilder中
                    //这个while循环的目的是读取一个不止一位的数字暂存在stringbuilder中
                    while(c>='0'){
                        sb.append(c);
                        //让当前字符指向表达式中的下一个字符
                        j++;
                        //如果指向下一个字符后已经到了表达式的结尾了，就结束while循环
                        if(j==s.length())
                            break;
                        //更新当前处理的字符
                        c=s.charAt(j);
                        //下一次while循环时再判断新指向的下一个字符是不是数字，如果是数字，则重复以上操作
                        //如果不是数字则结束while循环
                    }
                    //i还是指向读完的那个多位数字的最后一个数字字符，因为外层for中去执行i++操作
                    //与最外层for循环的i++相呼应，如果是处理的一个多位字符的数字，for中的i++以后一定指向的应该是符号了
                    i=j-1;
                    //将刚才读到的数字转化成整数然后入栈
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
        //第一个while处理链表中的所有乘除法
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
        
        //第二个while处理链表中所有加减法
        while(list2.size()!=1){
            //读取第一个操作数
            int a=Integer.parseInt(list2.poll().toString());
            //读取操作符
            String s2=list2.poll().toString();
            //读取第二个操作数
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
