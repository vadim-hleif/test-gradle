package test;

import java.util.concurrent.atomic.AtomicReference;

// difficult unblocking algorithm example
public class ComplexSample<E> {

    private AtomicReference<Node<E>> tail = new AtomicReference<>(new Node<E>(null, null));

    public boolean put(E item) {
        Node<E> newNode = new Node<>(item, null);

        while (true) {
            Node<E> current = tail.get();
            Node<E> next = current.next.get();

            if (current == tail.get()) {

                if (next == null) /* A */ {

                    if (current.next.compareAndSet(null, newNode)) /* C */ {
                        tail.compareAndSet(current, newNode) /* D */;
                        return true;
                    }

                } else {
                    tail.compareAndSet(current, next) /* B */;
                }


            }
        }
    }

    private static class Node<E> {

        final E item;
        final AtomicReference<Node<E>> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<>(next);
        }
    }
}