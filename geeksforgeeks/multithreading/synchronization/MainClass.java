package geeksforgeeks.multithreading.synchronization;

public class MainClass
{
    public static void main(String[] args)
    {
        Counter counter = new Counter();
        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch (Exception e){
            System.out.println("Thread got interrupted. Exception: "+ e);
        }

        /**
         * Ideally, the final counter value should always be 2000 since each thread increments it 1000 times.
         * However, the output varies across runs because both threads share the same Counter object.
         * Without synchronization, multiple threads can update the counter simultaneously, causing race conditions.
         * As a result, some increments are lost and the final value is less than expected.
         * Add synchronised block in increment metjod then it will always return 2000
         * This is also called mutual exclusion
         */
        System.out.println(counter.getCounter());

    }
}
