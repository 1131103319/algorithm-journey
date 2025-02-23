package class046;

// 利用前缀和快速得到区域累加和
// 测试链接 : https://leetcode.cn/problems/range-sum-query-immutable/
public class Code01_PrefixSumArray {
//todo sum保存前缀和，计算区间时只需要将总和-不包含的和即可
	class NumArray {

		public int[] sum;

		public NumArray(int[] nums) {
			sum = new int[nums.length + 1];
			for (int i = 1; i <= nums.length; i++) {
				sum[i] = sum[i - 1] + nums[i - 1];
			}
		}

		public int sumRange(int left, int right) {
			return sum[right + 1] - sum[left];
		}
	}

}
