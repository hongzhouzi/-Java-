package ������ϰ;

public class ���Ԫһ�η��� {
	public static void main(String[] args) {
		/*ax+by=c
		 * ax=c-by
		 * 1.���һ���ؽ� x0 y0
		 * 2.��ͨ�⣺x=x0+bt��y=y0-at
		 * ������4*x-5*y=7�Ľ⣬0<=y<10
		 * */
		for(int y=1;y<10;y++){
			if((7+5*y)%4==0){
				System.out.print("x="+(7-(-5*y))/4);
				System.out.println("  y="+y);
			}
		}
	}
}
