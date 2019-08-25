package 听课练习;

public class 解二元一次方程 {
	public static void main(String[] args) {
		/*ax+by=c
		 * ax=c-by
		 * 1.求出一个特解 x0 y0
		 * 2.求通解：x=x0+bt，y=y0-at
		 * 例：求4*x-5*y=7的解，0<=y<10
		 * */
		for(int y=1;y<10;y++){
			if((7+5*y)%4==0){
				System.out.print("x="+(7-(-5*y))/4);
				System.out.println("  y="+y);
			}
		}
	}
}
