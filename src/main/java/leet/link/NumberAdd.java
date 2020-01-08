package leet.link;

import org.junit.Test;


/**
 * desc:
 * author: liuxiaozheng
 * time: 2019/12/13  10:13
 **/
public class NumberAdd {

    @Test
    public void add (){
        System.out.println("123");

        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(3);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;

        ListNode listNode = this.addNodes(node11, node21);

        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


    private ListNode addNodes(ListNode node1, ListNode node2){

        ListNode header = new ListNode(0);

        ListNode result = header;

        int carry = 0;

        while (true){
            if (node1 == null && node2 == null && (carry == 0)){
                return header.next;
            }
            if (node1 == null){
                node1 = new ListNode(0);
            }
            if (node2 == null){
                node2 = new ListNode(0);
            }

            int sum = node1.val + node2.val + carry;

            carry = sum / 10;
            sum = sum % 10;

            ListNode nextNode = new ListNode(sum);
            result.next = nextNode;
            result = nextNode;

            node1 = node1.next;
            node2 = node2.next;
        }
    }

    @Test
    public void mergeNodes (){

        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(6);
        ListNode node13 = new ListNode(7);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(9);
        node21.next = node22;
        node22.next = node23;

//        ListNode listNode = this.mergeNodes(node11, node21);
//        while(listNode != null){
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        ListNode listNode2 = this.mergeNodes2(node11, node21);

        System.out.println("-------------------");
        while(listNode2 != null){
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }

    }
    private ListNode mergeNodes(ListNode node1, ListNode node2){
        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }

        ListNode result = node1;

        while(node2 != null){
            if (node1.val > node2.val){
                ListNode newNode = new ListNode(node2.val);

                newNode.next = result;

                result = newNode;

                node1 = newNode;
                node2 = node2.next;
                continue;
            }
            while(true){
                if (node1.val < node2.val && node1.next != null){
                    if (node1.next.val > node2.val){
                        break;
                    }
                    node1 = node1.next;
                } else{
                    break;
                }
            }

            ListNode oldNext = node1.next;

            ListNode newNode = new ListNode(node2.val);

            node1.next = newNode;

            if (oldNext != null){
                newNode.next = oldNext;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return result;
    }
    private ListNode mergeNodes2(ListNode node1, ListNode node2){
        ListNode header = new ListNode(0);

        ListNode cur = header;

        while(node1 != null && node2 != null){
            if (node1.val < node2.val){
                cur.next = node1;
                cur = cur.next;
                node1 = node1.next;
            } else {
                cur.next = node2;
                cur = cur.next;
                node2 = node2.next;
            }
        }

        if (node1 == null){
            cur.next = node2;
        }

        if (node2 == null){
            cur.next = node1;
        }

        return header.next;

    }

}
