package geeksforgeeks.multithreading.synchronization;

public class MyThread extends Thread
{
    Counter counter;


    public  MyThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        int i=0;
        while (i<1000){
            counter.incrementCount();
            i++;
        }
    }
}
