package queue.linked;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Singularity
 * @createTime 2022年04月24日 10:49:00
 * @Description 结点定义
 */
@Data
@NoArgsConstructor
public class Node {
    Object data;
    Node next;
    public Node(Object data){
        this.data = data;
    }
}
