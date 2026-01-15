package geeksforgeeks.multithreading2;

public class MainExtendingThread
{
    public static void main(String[] args)
    {
        MultithreadingExtendindingThread multithreadingExtendindingThread = new MultithreadingExtendindingThread();
        multithreadingExtendindingThread.start();
        System.out.println("Ending the process"+ Thread.currentThread().getName());
    }
}
