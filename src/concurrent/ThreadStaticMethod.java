package concurrent;

import java.time.LocalDateTime;

//test Thread.sleep() static method
//cause running
public class ThreadStaticMethod {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("main thread starts. and wait for 4 seconds..");
        Thread.sleep(2000);
        LocalDateTime then = LocalDateTime.now();
        int timeElipse = (then.getMinute()-now.getMinute())*60 + then.getSecond()-now.getSecond();
        System.out.println("main thread resumes..."+ timeElipse);

        System.out.println(Thread.interrupted());
    }
}
