package 挑战程序设计竞赛题目;
/*
 给定一个大小为N×M的迷宫。迷宫由通道和墙壁组成，每一步可以向邻接的上下左右四格
的通道移动。请求出从起点到终点所需的最小步数。请注意，本题假定从起点一定可以移动
到终点。
限制条件： N, M ≤ 100
	输入：N=10, M=10（迷宫如下图所示。'#'，'.'，'S'，'G'分别表示墙壁、通道、起点和终点）
	#S######.#
	......#..#
	.#.##.##.#
	.#........
	##.##.####
	....#....#
	.#######.#
	....#.....
	.####.###.
	....#...G#
	输出：22 
	思路：宽度优先搜索按照距开始状态由近及远的顺序进行搜索，因此可以很容易地用来求最短路径、最少操作之类问题的答案
 * */
import java.util.LinkedList;
import java.util.Queue;
public class 迷宫的最短路径 {
	static final int INF=100000000;
	static int MAX_N = 100,MAX_M = 100,N=10, M=10;
	static int sx, sy; // 起点坐标
	static int gx, gy; // 终点坐标
	static Queue<Integer> queue=new LinkedList<Integer>(); 
	static char[][]maze=new char[MAX_N][MAX_M]; // 表示迷宫的字符串的数组
	/*maze={
			{'#','S','#','#','#','#','#','#','.','#'},
			{'.','.','.','.','.','.','#','.','.','#'},
			{'.','#','.','#','#','.','#','#','.','#'},
			{'.','#','.','.','.','.','.','.','.','.'},
			{##.##.####},
			{....#....#},
			{.#######.#},
			{....#.....},
			{.####.###.},
			{....#...G#}
	};*/
	static int[][]d=new int[MAX_N][MAX_M]; 		// 到各个位置的最短距离的数组
	static int [][]visited=new int[MAX_N][MAX_M];  //记录该处是否被访问
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};	// 4个方向移动的向量
	static void bfs(){
		for (int i = 0; i < N; i++)  
	        for (int j = 0; j < M; j++)  
	            d[i][j] = INF;  //初始化所有点的距离为INF  
		queue.offer(1);	//把起点添加进去
		d[sx][sy] = 0;  //从起点出发将距离设为0，并放入队列首端  
		visited[sx][sy]=1;	//把起始点标记为已访问
		// 不断循环直到队列的长度为0
		while (!queue.isEmpty()) {
		// 从队列的最前端取出元素
			int index=queue.poll();  
            int x=index/M;  
            int y=index%M;  
		
            for(int i=0;i<4;i++){  
                int nx=x+dx[i];  
                int ny=y+dy[i];  
                if(nx>=0 && nx<N && ny>=0 && ny<M && maze[nx][ny]=='.' && visited[nx][ny]==0){  
                    queue.offer(nx*M+ny);  
                    visited[nx][ny]=1;  
//                    fa[nx][ny]=index;  
//                    last_dir[nx][ny]=i;  
                }  
            }  
		}
		
	}
}
