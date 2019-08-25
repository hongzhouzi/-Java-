package leetCode;

public class 山脉数组的峰顶索引 {
	public static void main(String[] args) {
		int a[]={0,1,0};
		int b[]={0,2,1,0};
		System.out.println(peakIndexInMountainArray(b));
	}
	static int peakIndexInMountainArray(int[] A) {
        int lenA=A.length;
        for(int i=1;i<lenA-1;i++){
        	if(A[i-1]<A[i] && A[i]>A[i+1]){
        		return i;
        	}
        }
        return -1;
    }
}
