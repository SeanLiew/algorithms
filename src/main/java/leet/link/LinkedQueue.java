package leet.link;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description:
 * @author: liuxiaozheng
 * @Created: 2020-05-28-23:45
 */
public class LinkedQueue<E> {
    private static class Node<E>{
        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next){
            this.item = item;
            this.next = new AtomicReference<>();
        }
    }
    private final Node<E> dummy = new Node<E>(null, null);
    private final AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<Node<E>>(dummy);

    public boolean put(E item){
        Node<E> newNode = new Node<E>(item, null);
        while(true){
            Node<E> curTail = tail.get();
            Node<E> nextTail = curTail.next.get();
            if (curTail == tail.get()){
                if (nextTail != null){
                    //队列处于中间状态，推进尾节点
                    tail.compareAndSet(curTail, nextTail);
                }
                else{
                    //处于稳定态，尝试插入新节点
                    if (curTail.next.compareAndSet(null, newNode)){
                        // 插入成功，推进尾节点
                        tail.compareAndSet(curTail, newNode);
                        return true;
                    }

                }
            }

        }
    }
}
