package test;

import java.util.concurrent.CountDownLatch;

//Deadlock
public class DeadlockWithoutThreadSleep {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Account account = new Account();
        Account second = new Account();

        new Thread(() -> {
            synchronized (account) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (second) {
                    System.out.println("1");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (second) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (account) {
                    System.out.println("2");
                }
            }
        }).start();

        countDownLatch.countDown();

    }
}

