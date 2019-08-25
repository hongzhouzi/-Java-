package practice;
import java.util.ArrayList;
import java.util.Scanner;

public class 学霸迷宫_参考答案 {
	public final static int[][] move = {{-1, 0},{1,0},{0,-1},{0,1}};//分别表示向上、下、左、右移动一步
    public final static String[] onePath = {"U","D","L","R"};//分别表示向上、下、左、右行走
    
    static class point {   //内部类，用于表示当前行走到达点信息
        public int x;  //当前到达位置横坐标
        public int y;  //当前到达位置纵坐标
        public int step;   //行走到当前顶点所用总步数
        public String path;   //行走到当前顶点的具体路径
        
        point(int x, int y, int step, String path) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.path = path;
        }
    }
        
    //判断当前位置是否是可行走的位置，如不能返回false，否则返回true
    public static boolean check(int[][] matrix, point a) {
        int n = matrix.length - 1, m = matrix[0].length - 1;
        if(a.x < 1 || a.x > n || a.y < 1 || a.y > m || matrix[a.x][a.y] == 1)
            return false;
        return true;
    }
    
    //依据字典序{D,L,R,U}，比较字符串A和B的大小，如果A > B返回true，否则返回false(PS:两者字符个数相同)
    public static boolean judge(String A, String B) {
        char[] arrayA = A.toCharArray();
        char[] arrayB = B.toCharArray();
        for(int i = 0, len = A.length();i < len;i++) {
            if(arrayA[i] < arrayB[i])
                return false;
        }
        return true;
    }
    //把输入数据，变换为矩阵
    public static int[][] getMatrix(String[] A, int m) {
        int[][] matrix = new int[A.length + 1][m + 1];
        for(int i = 0;i < A.length;i++) {
            char[] arrayA = A[i].toCharArray();
            for(int j = 0;j < m;j++)
                matrix[i + 1][j + 1] = arrayA[j] - '0';
        }
        return matrix;
    }
    
    public static void bfs(String[] A, int m) {
        int[][] matrix = getMatrix(A, m);
        ArrayList<point> list = new ArrayList<point>();
        list.add(new point(1,1,0,""));   //表示从顶点(1,1)出发
        int minStep = Integer.MAX_VALUE;  //用于记录到达最终顶点所需最少步数
        String minPath = "";         //用于记录到达最终顶点路径的最小字典序序列
        while(list.size() != 0) {
            point begin = list.get(0);  //获取链表第一个顶点，开始进行bfs遍历
            list.remove(0);  //删除进行遍历的起始点
            
            if(begin.x == matrix.length - 1 && begin.y == matrix[0].length - 1) {  //当该顶点为终点时
                if(minStep > begin.step) {
                    minStep = begin.step;
                    minPath = begin.path;
                } else if(minStep == begin.step) { 
                    if(judge(minPath, begin.path))  //当minPath字典序大于begin.step时
                        minPath = begin.path;
                }
                continue;   //此处已经是终点，不需要进行下面bfs遍历
            }
            
            for(int i = 0;i < 4;i++) {  //如果未达到最终顶点(n, m)，进行bfs遍历(分别向上、下、左、右移动)
                int x = begin.x + move[i][0];
                int y = begin.y + move[i][1];
                int step = begin.step + 1;
                String path = begin.path + onePath[i] ;
                point temp = new point(x, y, step, path);
                if(check(matrix, temp)) {  //当顶点temp是可到达的顶点时
                    list.add(temp);
                    matrix[x][y] = 1;  //到达该顶点后，标记该顶点不可到达，此处奥秘是大大减少了检索次数（如果换成其父母顶点不可到达，则会运行超时）
                }
            }
        }
        //输出最终结果
        System.out.println(minStep+"\n"+minPath);
        return;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();  //此处特别注意，输入完整数，下面接着输出字符串，此处处理换行操作
        String[] A = new String[n];
        for(int i = 0;i < n;i++)
            A[i] = in.nextLine();
        bfs(A, m);
        /*
         	输入：3 3
				001
				100
				110
			输出：4
				RDRD
         * */
    }
}
