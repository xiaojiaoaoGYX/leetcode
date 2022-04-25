package array.twonumsadd;

/**
 * @author Singularity
 * @createTime 2022年04月14日 08:46:00
 * @Description 两数相加
 */
public class TwoNumsAdd {

   //两数之和_时间复杂度O(max(l1.length,l2.length))); 空间复杂度O(1),返回值不计入空间复杂度
   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode head = null;
      ListNode tail = null;
      int carry = 0;
      while (l1 != null || l2 != null){
         int n1 = l1 != null ? l1.val : 0;
         int n2 = l2 != null ? l2.val : 0;
         int sum = n1 + n2 +carry;
         if (head == null){ //从第一位数字开始相加
            head = tail = new ListNode(sum%10);
         }else {
            tail.next = new ListNode(sum%10);
            tail = tail.next;
         }
         carry = sum/10;
         if (l1 != null){
            l1 = l1.next;
         }
         if (l2 != null){
            l2 = l2.next;
         }
      }
      if (carry>0){
         tail.next = new ListNode(carry);
      }
      return head;
   }

   public static void main(String[] args){
      //main方法测试
      ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3)));
      ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));
      System.out.println("nodeResult:"+addTwoNumbers(node1,node2));
   }

}
