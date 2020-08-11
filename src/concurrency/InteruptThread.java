package concurrency;

import java.util.stream.IntStream;

public class InteruptThread {
    static class Task implements Runnable {
        public void countDown() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("get called to start counting...");
            }
            IntStream.range(1, 201).forEach(System.out::println);
        }

        @Override
        public void run() {
            countDown();
        }

        public Task(int index) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task(1));
        t1.start();
        Thread.sleep(1000);
        System.out.println("interupt thread 1 to start counting...");
        t1.interrupt();
        t1.join();
        System.out.println("t1 complete, is still alive =?" + t1.isAlive());
    }
}
