package string;

import java.util.*;

/**
 * @author Singularity
 * @createTime 2022年04月25日 16:45:00
 * @Description 不含有重复字符的 最长子串 的长度
 */
public class lengthOfLongestSubstring {

    /**
     *    滑窗思想：
     *           将字符串看成一个队列，每次都将队列的第一个元素作为队头计算 不含重复字符的最长子串的长度，
     *           不断的移出左边的元素，直到计算完整个队列。
     *           比如‘abcabcbb’看称一个队列，当入队到‘abc’时满足要求，当再进入a时，队列变成了abca，
     *           这时候不满足要求。此时向左移动队列即将左边的元素移出，直到满足要求；
     *           一直维持这样的队列，找出队列的最长的长度。
     * 时间复杂度：O(N)，其中N是字符串的长度。左指针和右指针分别会遍历整个字符串一次 ？
     * 空间复杂度：O(∣Σ∣)，其中Σ表示字符集（即字符串中可以出现的字符），∣Σ∣ 表示字符集的大小。
     *           在本题中没有明确说明字符集，因此可以默认为所有 ASCII 码在 [0, 128)内的字符，即∣Σ∣=128。
     *          我们需要用到哈希集合来存储出现过的字符，而字符最多有 ∣Σ∣个，因此空间复杂度为 O(∣Σ∣)。？
     */
    public static int solution1(String str){
        if (str.length() == 0) return 0;
        HashSet<Character> hashSetTemp = new HashSet<>();
        int rk = -1,ans = 0;
        for (int i = 0; i<str.length();i++){
            if (i != 0){
                //左指针向右移动一格，移除一个字符
                hashSetTemp.remove(str.charAt(i-1));
            }
            while (rk + 1 < str.length() && !hashSetTemp.contains(str.charAt(rk+1))){
                //不断的移动右指针
                hashSetTemp.add(str.charAt(rk+1));
                ++rk;
            }
            ans = Math.max(ans, rk-i+1);
        }
        return ans;
    }


    /**
     *    滑窗思想：
     *           将字符串看成一个队列，若存在重复字符时，左指针向右移动至被重复字符的下一个位置（例如，第2个w出现时，left移动至第一个w的下一个位置），
     *           根据hashmap特点，将携带着新位置的重复元素重新存入map中。
     *           比如‘pwwkew’看称一个队列，当入队到‘pw’时满足要求，当再进入w时，队列变成了pww，
     *           此时左指针left指向被重复元素的下一个位置w=2，重复元素w重新存入map:(w,2),一直维持这样的队列，直到找出最大长度。
     *           (p,0)
     *           (w,1)
     *           (w,2)  left=2
     *           (k,3)
     *           (e,4)
     *           (w,5) left=3
     * 时间复杂度：O(N)，其中N是字符串的长度。
     * 空间复杂度：
     */
    public static int solution2(String str){
        if (str.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0;i<str.length();i++){
            if (map.containsKey(str.charAt(i))){
                //左指针向右移动至被重复元素的下一个位置
                left = Math.max(left, map.get(str.charAt(i))+1);
            }
            map.put(str.charAt(i), i);
            //取不含重复字符的字串的最长长度
            max = Math.max(max, i-left);
        }
        return max;
    }

    public static void main(String[] args){
        String str = "pwwkew";
        System.out.println("不含有重复字符的最长子串的长度(解法1)："+solution1(str));
        System.out.println("不含有重复字符的最长子串的长度(解法2)："+solution2(str));
    }
}
