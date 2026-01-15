package geeksforgeeks.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2
{
    Runnable runnableClass = ()->{
        System.out.println("Test");
    };

    Thread t1 = new Thread(runnableClass, "Thread1");
    { // instance initializer block
        t1.start();
    }

}
