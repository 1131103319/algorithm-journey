package class030;

// 找到缺失的数字
// 测试链接 : https://leetcode.cn/problems/missing-number/
public class Code03_MissingNumber {

	public static int missingNumber(int[] nums) {
		int eorAll = 0, eorHas = 0;
		for (int i = 0; i < nums.length; i++) {
			eorAll ^= i;
			eorHas ^= nums[i];
		}
		eorAll ^= nums.length;
		return eorAll ^ eorHas;
	}

}
//my code
class Solution {
    public int missingNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans^=nums[i];
        }
        for(int i=1;i<=nums.length;i++){
            ans^=i;
        }
        return ans;
    }
}
