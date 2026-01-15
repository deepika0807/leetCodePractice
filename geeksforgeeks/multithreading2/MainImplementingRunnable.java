package geeksforgeeks.multithreading2;

public class MainImplementingRunnable
{
    public static void main(String[] args)
    {
        MultithreadingImplimentingRunnable runnableObject = new MultithreadingImplimentingRunnable();
        Thread thread1 = new Thread(runnableObject);
        thread1.start();
        System.out.println("Finished Main method:"+ Thread.currentThread().getName());
    }
}
