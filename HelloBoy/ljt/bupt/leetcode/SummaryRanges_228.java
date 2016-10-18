package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges_228 {

	public static void main(String[] args) {
		int[] nums = {0,1,2,4,5,8};
		List<String> res = summaryRanges(nums);
		System.out.println(res);
	}

	private static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if(nums.length==0||nums==null)
			return res;
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int end = 0;
		while(end<nums.length){
			if((end+1<nums.length)&&nums[end+1]-1==nums[end]){
				end++;
			}else{
				sb.append(nums[start]);
				if(start!=end){
					sb.append("->" +nums[end]);
				}
				res.add(sb.toString());
				sb.delete(0, sb.length());
				start = end+1;
				end = end +1;
			}
		}
		return res;
	}

}
