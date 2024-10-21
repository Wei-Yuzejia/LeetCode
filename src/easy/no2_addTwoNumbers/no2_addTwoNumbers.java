package easy.no2;

public class no2_addTwoNumbers {

    public static void main(String[] args)
    {
        // 创建链表节点
        ListNode l1_1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l1_2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l2_1 = new ListNode(7, new ListNode(0, new ListNode(8)));
        ListNode l2_2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l3_1 = new ListNode(1, new ListNode(8));
        ListNode l3_2 = new ListNode(0);

        // 测试链表相加
        ListNode result1 = Solution(l1_1, l1_2);
        ListNode result2 = Solution(l2_1, l2_2);
        ListNode result3 = Solution(l3_1, l3_2);

        // 打印结果
        printList(result1); // 输出： 7 -> 0 -> 8
        printList(result2); // 输出： 8 -> 9 -> 9 -> 9 -> 1
        printList(result3); // 输出： 1 -> 8

    }
    /**
     * 对两个链表进行相加操作。
     * @param l1 第一个链表的头节点。
     * @param l2 第二个链表的头节点。
     * @return 返回一个新的链表，其每个节点的值是输入的两个链表中对应位置节点值的和。如果和超过10，则进位到下一个节点。
     */
    public static ListNode Solution(ListNode l1, ListNode l2) {
        // 创建一个新的链表头节点
        ListNode head = null, tail = null;
        // 进位
        int carry = 0;
        while(l1 != null || l2 != null){
            // 为了保持下面代码的通用性，需要对特殊情况进行讨论
            if(l1 == null){
                l1 = new ListNode(0);
            }
            if(l2 == null){
                l2 = new ListNode(0);
            }
            // 求出当前位的和以及进位
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;

            // 区分头结点和其余结点，这也是前面将 head、tail 均设置为 null 的原因
            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else{
                // 移动 tail 尾结点
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }
        // 如果最后仍有进位的话，请加上这个进位 1
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    /**
     * 打印链表中的所有元素。
     * @param head 链表的头节点。
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        System.out.print(current.val);
        current = current.next;
        while (current != null) {
            System.out.print(" -> " + current.val);
            current = current.next;
        }
        System.out.println(" ");
    }
}
