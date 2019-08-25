package ��ս������ƾ�����Ŀ;
/*
 ����һ����СΪN��M���Թ����Թ���ͨ����ǽ����ɣ�ÿһ���������ڽӵ����������ĸ�
��ͨ���ƶ������������㵽�յ��������С��������ע�⣬����ٶ������һ�������ƶ�
���յ㡣
���������� N, M �� 100
	���룺N=10, M=10���Թ�����ͼ��ʾ��'#'��'.'��'S'��'G'�ֱ��ʾǽ�ڡ�ͨ���������յ㣩
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
	�����22 
	˼·����������������վ࿪ʼ״̬�ɽ���Զ��˳�������������˿��Ժ����׵����������·�������ٲ���֮������Ĵ�
 * */
import java.util.LinkedList;
import java.util.Queue;
public class �Թ������·�� {
	static final int INF=100000000;
	static int MAX_N = 100,MAX_M = 100,N=10, M=10;
	static int sx, sy; // �������
	static int gx, gy; // �յ�����
	static Queue<Integer> queue=new LinkedList<Integer>(); 
	static char[][]maze=new char[MAX_N][MAX_M]; // ��ʾ�Թ����ַ���������
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
	static int[][]d=new int[MAX_N][MAX_M]; 		// ������λ�õ���̾��������
	static int [][]visited=new int[MAX_N][MAX_M];  //��¼�ô��Ƿ񱻷���
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};	// 4�������ƶ�������
	static void bfs(){
		for (int i = 0; i < N; i++)  
	        for (int j = 0; j < M; j++)  
	            d[i][j] = INF;  //��ʼ�����е�ľ���ΪINF  
		queue.offer(1);	//�������ӽ�ȥ
		d[sx][sy] = 0;  //����������������Ϊ0������������׶�  
		visited[sx][sy]=1;	//����ʼ����Ϊ�ѷ���
		// ����ѭ��ֱ�����еĳ���Ϊ0
		while (!queue.isEmpty()) {
		// �Ӷ��е���ǰ��ȡ��Ԫ��
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
