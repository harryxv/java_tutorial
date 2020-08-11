package concurrency;

//two ways to direct control thread

//example: count from 1 to 100 inclusive
public class DirectControlThreadManagement {
    public static void countDown() {
        //IntStream.range(1, 101).forEach(System.out::println);
        for (int i = 1; i <= 400; i++) {
            System.out.println(i);
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            countDown();
        }
    }

    //The Thread class itself implements Runnable
    static class TaskThread extends Thread {
        int index = 0;

        @Override
        public void run() {
            System.out.println("thread" + index + " is running...");
            countDown();
        }

        public TaskThread(int index) {
            this.index = index;
        }
    }

    //t1.join(): main thread(calling thread) should wait till t1 complete.
    //this is useful when testing thread, till thread finish job the testing class can terminate.
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new TaskThread(1);
        t1.start();
        t1.join();
        System.out.println("Main Thread running...");
        countDown();
    }
}
