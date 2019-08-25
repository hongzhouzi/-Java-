package 挑战程序设计竞赛题目;

public class LakeCount {
    static int[][] field = {
                            {1,0,0,0,0,0,0,0,0,1,1,0},
                            {0,1,1,1,0,0,0,0,0,1,1,1},
                            {0,0,0,0,1,1,0,0,0,1,1,0},
                            {0,0,0,0,0,0,0,0,0,1,1,0},
                            {0,0,0,0,0,0,0,0,0,1,0,0},
                            {0,0,1,0,0,0,0,0,0,1,0,0},
                            {0,1,0,1,0,0,0,0,0,1,1,0},
                            {1,0,1,0,1,0,0,0,0,0,1,0},
                            {0,1,0,1,0,0,0,0,0,0,1,0},
                            {0,0,1,0,0,0,0,0,0,0,1,0}
                            };
    static int N = 10;
    static int M = 12;
    public static void DFS(int x,int y){
        field[x][y] = 0;
        for (int dx = -1;dx<=1;dx++){
            for (int dy = -1;dy<=1;dy++){
                int nx = x + dx;
                int ny = y + dy;
                if(0<=nx&&nx<N&&0<=ny&&ny<M&&1==field[nx][ny]) DFS(nx,ny);
            }
        }
        return;
    }
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0;i<N;i++){
            for (int j =0;j<M;j++){
                if (1==field[i][j]){
                    DFS(i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
   
}

