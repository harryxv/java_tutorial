package concurrency;

//Thread creation
public class ThreadCreation {
    public static Thread createThreadFromRunnable() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in thread " + Thread.currentThread().getName());
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
                //throw new RuntimeException("run time exception happend.");
            }
        });
        thread.setName("New-Worker-Thread");
        //set thread priority
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName()
                        + " the error is " + e.getMessage());
            }
        });
        return thread;
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("We are now in thread " + this.getName());
            System.out.println("Current thread priority is " + this.getPriority());
            //throw new RuntimeException("run time exception happend.");
        }

        public NewThread() {
            this.setPriority(8);
            this.setName("New-Worker-Thread-2");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = createThreadFromRunnable();
        System.out.println("We are now in thread " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("We are now in thread " + Thread.currentThread().getName() + " after starting a new thread");

        Thread thread2 = new NewThread();
        System.out.println("We are now in thread " + Thread.currentThread().getName() + " before starting a new thread");
        thread2.start();
        System.out.println("We are now in thread " + Thread.currentThread().getName() + " after starting a new thread");
    }
}
