package geeksforgeeks.multithreading.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;


public class Banking
{
    private int balance = 1000;

    /***
     * Because in a multithreaded class:
     *
     * You want to ensure that all threads use the exact same lock object.
     *
     * If lock could be reassigned (non-final), you might accidentally replace it with a new ReentrantLock(), which would break synchronization (threads might be locking on different objects).
     *
     * By declaring it final:
     *
     * You guarantee that the reference to the lock object never changes.
     *
     * Every call to lock.lock() / lock.unlock() uses the same lock instance.
     */
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+ " attempting to withdraw " + amount);
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS )){
                if(balance > amount){
                    System.out.println(Thread.currentThread().getName()+ " proceeding with withdraw");
                    Thread.sleep(3000);
                    balance-=amount;
                }

            }
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }finally
        {
           lock.unlock();
        }
    }
}
