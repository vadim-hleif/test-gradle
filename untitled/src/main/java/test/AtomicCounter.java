package test;

import java.util.concurrent.atomic.AtomicInteger;

// thread safe counter
public class AtomicCounter {

    public static AtomicInteger var = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        AtomicCounter main = new AtomicCounter();
        Thread thread = new Thread(main::first);
        Thread thread2 = new Thread(main::second);

        thread.start();
        thread2.start();

    }

    public void first() {
        for (int i = 0; i < 150; i++) {
            new Thread(() -> {
                var.incrementAndGet();
                System.out.println(var);
            })
                .start();
        }
    }

    public void second() {
        for (int i = 0; i < 100; i++) {

            new Thread(() -> {
                var.incrementAndGet();
                System.out.println(var);

            })
                .start();
        }
    }
}

