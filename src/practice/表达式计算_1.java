package practice;

import java.util.Scanner;
import java.util.Stack;


public class ���ʽ����_1{
    public void getExpressionValue(String A){
        char[] arrayA = A.toCharArray();
        Stack<Integer> Value = new Stack<Integer>();      //����������ּ����ʽ������
        Stack<Character> Operator =  new Stack<Character>();   //��������
        for(int i = 0;i < A.length();i++){
            int temp = 0;
            if(arrayA[i] >= '0' && arrayA[i] <= '9'){	//�жϸ�λ������
                temp = arrayA[i] - '0';
                i = i + 1;
                while(i < A.length() && arrayA[i] >= '0' && arrayA[i] <= '9'){	//������������
                    temp = temp * 10 + (arrayA[i] - '0');
                    i++;
                }
                i--;     //��Ӧ����һ��i = i+1;��Ϊ��forѭ������i++��������������ִ�д˾䣬�ᵼ��i��������
                Value.push(temp);
            }
            else{	//�ж�Ϊ�������ʱ
                if(Operator.empty()){
                   Operator.push(arrayA[i]);
                }
                else{
                    char temp1 = Operator.pop();   //��ջǰ����������ջ��ջ������ַ�
                    int judge = comparePriority(temp1,arrayA[i]);  //�Ƚϵ�ǰ�ַ���ջ���ַ����ȼ�
                    if(judge == 1){           //��ǰ�ַ����ȼ�С��ջ���ַ�
                        int tempA = Value.pop();
                        int tempB = Value.pop();
                        int result = computeNumber(tempB,tempA,temp1);
                        Value.push(result);
                        Operator.push(arrayA[i]);
                    }
                    if(judge == 0){           //��ǰ�ַ����ȼ�����ջ���ַ�
                        Operator.push(temp1);
                        Operator.push(arrayA[i]);
                    }
                    if(judge == 2){  //�ַ�')'����'('���պ�ʹ��'('��ջ
                        System.out.println("'('�պ�����')'");   //�������ҲӦ�ò�����֣����ո������ȼ���')'һ���������+��-��*��/�ַ�
                    }
                    if(judge == 3){   //��ʱ')'�պ�׼����ջ
                        while(temp1 != '('){          //')'�ַ�Ҫ�ȵ���һ��'('��ջ���ܽ���ѭ��
                            //System.out.println(temp1);
                            int tempA = Value.pop();
                            int tempB = Value.pop();
                            int result = computeNumber(tempB,tempA,temp1);
                            Value.push(result);
                            temp1 = Operator.pop();  
                        }
                    }
                    if(judge == -1){    //��ʱ��˵����ǰջ���ַ�Ϊ')'�����ǲ����ڵģ���Ϊ����')'����Ҫ���ý�ջ
                        System.out.println("����ջ����')'���󣡣���");
                    }
                }
            }
        }
        
        while(!Operator.empty() && !Value.empty()){   //��ʱ���ַ�ջ�л���������������
            char temp1 = Operator.pop();
            int tempA = Value.pop();
            int tempB = Value.pop();
            int result = computeNumber(tempB,tempA,temp1);
            Value.push(result);
        }
        System.out.println(Value.pop());   //��ʱ�����ջΪ�գ�����ջ��ֻ���ڱ��ʽ�������ս��
    }
    //����a operator b��ֵ��operator = {+,-,*,/}
    public int computeNumber(int a,int b,char operator){
        int result;
        switch(operator){
        case '+': 
            result = a+b;
            break;
        case '-':
            result = a-b;
            break;
        case '*': 
            result = a*b;
            break;
        case '/': 
            result = a/b;
            break;        
        default:  
            result = 0;
            break;
        }
        return result;
    }
    //�ж������a��b�����ȼ�
    public int comparePriority(char a,char b){
        //ʹ�ö�ά�����������֮������ȼ��������ַ�a��ʾ�������ַ�b��ʾ
        int[][] Value = {	{1,1,0,0,0,3},
			                {1,1,0,0,0,3},
			                {1,1,1,1,0,3},
			                {1,1,1,1,0,3},
			                {0,0,0,0,0,2},
			                {-1,-1,-1,-1,-1,-1}};
        int i = 0;
        int j = 0;
        if(a == '+')
            i = 0;
        if(a == '-')
            i = 1;
        if(a == '*')
            i = 2;
        if(a == '/')
            i = 3;
        if(a == '(')
            i = 4;
        if(a == ')')
            i = 5;
        
        if(b == '+')
            j = 0;
        if(b == '-')
            j = 1;
        if(b == '*')
            j = 2;
        if(b == '/')
            j = 3;
        if(b == '(')
            j = 4;
        if(b == ')')
            j = 5;
        return Value[i][j];
    }
    
    public static void main(String[] args){
    	���ʽ����_1 test = new ���ʽ����_1(); 
        Scanner in = new Scanner(System.in);
        System.out.println("������һ���㷨���ʽ��");
        String A = in.nextLine();
        test.getExpressionValue(A);
    
    }
}