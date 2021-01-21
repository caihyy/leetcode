package editor.cn;

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1083 👎 0

import java.util.HashMap;

public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int num =0;
        ListNode nextNode = head;
        HashMap<Integer,ListNode> hashMap = new HashMap<>(1000);
        while(nextNode != null){
            hashMap.put(num,nextNode);
            num++;
            nextNode = nextNode.next;
        }
        int size = hashMap.size();
        if (n == size){
            return n==1 ? null : hashMap.get(1);
        }
        nextNode = hashMap.get(hashMap.size()-n-1);

        if (n==1){
            nextNode.next = null;
        }else {
            nextNode.next = hashMap.get(hashMap.size()-n+1);
        }
        return hashMap.get(0);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}