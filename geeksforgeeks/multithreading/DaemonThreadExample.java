package geeksforgeeks.multithreading;

public class DaemonThreadExample extends Thread
{
    @Override
    public void run(){
        while(true){
            System.out.println(Thread.currentThread().getName());
        }

    }
    public static void main(String[] args)
    {
//        One way of execution
//        DaemonThreadExample daemonThreadExample = new DaemonThreadExample();
//        Thread t1 = new Thread (daemonThreadExample, "Daemon thread");
//        t1.setDaemon(true);

//        Another way of execution
        DaemonThreadExample daemonThreadExample = new DaemonThreadExample();
        daemonThreadExample.setDaemon(true);


        daemonThreadExample.start();
        System.out.println("Java will not wait Daemon thread ti finish it's execution");
    }
}
