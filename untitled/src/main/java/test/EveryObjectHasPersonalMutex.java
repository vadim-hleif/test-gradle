package test;

public class EveryObjectHasPersonalMutex {

    // show that every object has his own mutex
    public static void main(String[] args) throws InterruptedException {
        EveryObjectHasPersonalMutex main = new EveryObjectHasPersonalMutex();

        EveryObjectHasPersonalMutex main1 = new EveryObjectHasPersonalMutex();

        Thread thread1 = new Thread(main::second);
        Thread thread = new Thread(main1::first);

        thread1.start();
        thread.start();

        thread1.join();
    }

    synchronized public void first() {
        System.out.println("1");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void second() {
        System.out.println("2");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

