package array.twonumsadd;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Singularity
 * @createTime 2022年04月25日 14:53:00
 */
@Data
@NoArgsConstructor
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
