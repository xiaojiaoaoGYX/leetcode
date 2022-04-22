package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Singularity
 * @createTime 2022年04月13日 08:41:00
 * @Description 两数之和
 */
public class TwoNumsSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3,7,8,2,6,4,9};
        int[] result = hashMap1(nums, 6);

        System.out.println("result:"+ Arrays.toString(result));
    }

    //解法一：暴力搜索——时间复杂度O(n^2),空间复杂度O(1)
    public static int[] bruteForceSearch(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

    //解法二：哈希表版本1——时间复杂度O(n),空间复杂度O(n)
    public static int[] hashMap1(int[] nums,int taget){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i=0;i<nums.length-1;i++){
            int tem = taget - nums[i];
            if (map.containsKey(tem)){
                result[0] = map.get(tem);
                result[1] = i;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    //解法三：哈希表——时间复杂度O(n),空间复杂度O(n)
    public static int[] hashMap2(int[] nums,int target){
        int size = nums.length;
        Map<Integer, Integer> dic = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (dic.containsKey(target - nums[i])) {
                return new int[] { dic.get(target - nums[i]), i };
            }
            dic.put(nums[i], i);
        }
        return new int[0];
    }
}
