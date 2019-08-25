package leetCode;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int a[]={1,2,3,3,3,4};
		int len=removeDuplicates(a);
		for(int i=0;i<len;i++)
			System.out.println(a[i]);
	}
	static int  removeDuplicates(int[] nums) {
        int numsLen=nums.length,i=0;
        for(int j=0;j<numsLen;j++){
        	if(nums[i]!=nums[j]){
        		i++;
        		nums[i]=nums[j];
        	}
        }
        return i+1;
    }
}
