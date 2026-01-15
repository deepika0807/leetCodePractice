package geeksforgeeks.multithreading2;

public class MultithreadingExtendindingThread extends Thread
{
    @Override
    public void run() {
        System.out.println("Executng Thread" + Thread.currentThread().getName());
    }
}
