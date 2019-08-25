package practice;

import java.util.Scanner;
import java.util.Stack;


public class 表达式计算_1{
    public void getExpressionValue(String A){
        char[] arrayA = A.toCharArray();
        Stack<Integer> Value = new Stack<Integer>();      //存放运算数字及表达式计算结果
        Stack<Character> Operator =  new Stack<Character>();   //存放运算符
        for(int i = 0;i < A.length();i++){
            int temp = 0;
            if(arrayA[i] >= '0' && arrayA[i] <= '9'){	//判断该位是数字
                temp = arrayA[i] - '0';
                i = i + 1;
                while(i < A.length() && arrayA[i] >= '0' && arrayA[i] <= '9'){	//继续向后读数字
                    temp = temp * 10 + (arrayA[i] - '0');
                    i++;
                }
                i--;     //对应上面一句i = i+1;因为在for循环中有i++自增操作，若不执行此句，会导致i自增两次
                Value.push(temp);
            }
            else{	//判断为运算符号时
                if(Operator.empty()){
                   Operator.push(arrayA[i]);
                }
                else{
                    char temp1 = Operator.pop();   //进栈前，存放运算符栈中栈顶存放字符
                    int judge = comparePriority(temp1,arrayA[i]);  //比较当前字符与栈顶字符优先级
                    if(judge == 1){           //当前字符优先级小于栈顶字符
                        int tempA = Value.pop();
                        int tempB = Value.pop();
                        int result = computeNumber(tempB,tempA,temp1);
                        Value.push(result);
                        Operator.push(arrayA[i]);
                    }
                    if(judge == 0){           //当前字符优先级大于栈顶字符
                        Operator.push(temp1);
                        Operator.push(arrayA[i]);
                    }
                    if(judge == 2){  //字符')'遇到'('，刚好使得'('出栈
                        System.out.println("'('刚好遇到')'");   //这种情况也应该不会出现，按照给定优先级，')'一般会先遇到+、-、*、/字符
                    }
                    if(judge == 3){   //此时')'刚好准备进栈
                        while(temp1 != '('){          //')'字符要等到第一个'('出栈才能结束循环
                            //System.out.println(temp1);
                            int tempA = Value.pop();
                            int tempB = Value.pop();
                            int result = computeNumber(tempB,tempA,temp1);
                            Value.push(result);
                            temp1 = Operator.pop();  
                        }
                    }
                    if(judge == -1){    //此时，说明当前栈顶字符为')'，这是不存在的，因为遇到')'，按要求不让进栈
                        System.out.println("出现栈顶有')'错误！！！");
                    }
                }
            }
        }
        
        while(!Operator.empty() && !Value.empty()){   //此时，字符栈中还存在运算符的情况
            char temp1 = Operator.pop();
            int tempA = Value.pop();
            int tempB = Value.pop();
            int result = computeNumber(tempB,tempA,temp1);
            Value.push(result);
        }
        System.out.println(Value.pop());   //此时运算符栈为空，数字栈中只存在表达式计算最终结果
    }
    //计算a operator b的值，operator = {+,-,*,/}
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
    //判断运算符a和b的优先级
    public int comparePriority(char a,char b){
        //使用二维数组表达运算符之间的优先级，行用字符a表示，列用字符b表示
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
    	表达式计算_1 test = new 表达式计算_1(); 
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个算法表达式：");
        String A = in.nextLine();
        test.getExpressionValue(A);
    
    }
}