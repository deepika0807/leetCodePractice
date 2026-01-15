package geeksforgeeks.multithreading;

public class MainThread
{
    public static void main(String[] args)
    {
//        Using Thread Class
        WorldExtendsThreadClass world = new WorldExtendsThreadClass("ThreadExtendingThreadClass");
        world.start();
        for ( int i=0; i< 10; i++){
            System.out.println(Thread.currentThread().getName() );
        }



//                Using Runnable
        WorldImplementsRunnableInterface worldImplementsRunnableInterface = new WorldImplementsRunnableInterface();
        Thread t1 = new Thread(worldImplementsRunnableInterface, "Thread1UsingRunnableInterface");
        t1.start();
    }
}
