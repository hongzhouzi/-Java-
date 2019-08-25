package leetCode;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s="b";
		
		System.out.println(longestPalindrome(s));
	}
	static String longestPalindrome(String s){
		String ansString="";
		int lenS=s.length(),lenMax=0;
		if(lenS<=1) return s;
		for(int i=0;i<lenS;i++){
			for(int j=i+1;j<=lenS;j++){
				if(judge(s.substring(i, j))){	//如果是回文字符串
					if(s.subSequence(i, j).length()>lenMax){
						ansString=s.substring(i,j);
						lenMax=s.subSequence(i, j).length();
					}
				}
			}
		}
		return ansString;
	}
	static boolean judge(String s){
		if(s.equals(reverse(s))){
			return true;
		}else {
			return false;
		}
	}
	static String reverse(String s){	//字符串反转
		return new StringBuilder(s).reverse().toString();
	}
	
	
	//中心扩展算法
	static public String longestPalindrome_(String s) {
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);	//对应奇数个，由中间一个向两边扩展
	        int len2 = expandAroundCenter(s, i, i + 1);	//对应偶数个，由中间两个向两边扩展
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	static private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
}
