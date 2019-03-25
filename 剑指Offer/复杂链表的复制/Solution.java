/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
//使用hash表来解决对应关系
import java.util.HashMap;
import java.util.Map;
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        RandomListNode cur_1 = pHead;
        Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode new_head = new RandomListNode(pHead.label);
        RandomListNode cur_2 = new_head;
        map.put(pHead,new_head);
        //复制next
        while(cur_1.next !=null){
            cur_2.next = new RandomListNode(cur_1.next.label);
            cur_1 = cur_1.next;
            cur_2 = cur_2.next;
            map.put(cur_1,cur_2);
        }
        
        //处理random
        cur_1 = pHead;
        cur_2 = new_head;
        while(cur_1!=null){
            RandomListNode randomNode = map.get(cur_1.random);
            cur_2.random = randomNode;
            cur_1 = cur_1.next;
            cur_2 = cur_2.next;
        }
        return new_head;
        
    }
}