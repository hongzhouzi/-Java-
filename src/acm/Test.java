package acm;

public class Test {
	public static void main(String[] args) {
		int x=index("Kanbara", 'x', 2);
		System.out.println(x);
	}
	
	static int index(String s,char ch,int start){
		return s.indexOf(ch, start);
	}
}
