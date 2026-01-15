package geeksforgeeks.multithreading.synchronization;

public class Counter
{
    private int counter = 0;

//    Asynchronous
//    public void incrementCount(){
//        counter++;
//    }

//    Synchronization : Two ways (1. Whole function synchronized, 2. Only block of code synchronized using synchronized block (this keyword represents current object))
//    public synchronized void incrementCount(){
//        counter++;
//    }

        public void incrementCount(){
            synchronized(this){
                counter++;
            }

        }

    public int getCounter(){
        return counter;
    }
}
