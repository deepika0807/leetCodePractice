package geeksforgeeks.multithreading2;

public class MultithreadingImplimentingRunnable implements Runnable
{

    @Override
    public void run()
    {
        System.out.println("Code executed by thread: "+ Thread.currentThread().getName());
    }
}
