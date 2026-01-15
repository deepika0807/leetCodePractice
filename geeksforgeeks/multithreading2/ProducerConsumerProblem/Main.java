package geeksforgeeks.multithreading2.ProducerConsumerProblem;

public class Main
{
    public static void main(String[] args)
    {
        SharedResources sharedBuffer = new SharedResources(3);
        Thread producerThread = new Thread(()->{
            try{
            for(int i=0; i< 6; i++){
                sharedBuffer.produce(i);
            }
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        });

        Thread consumeThread = new Thread(()->{
            try{
                for(int i=0; i< 6; i++){
                    sharedBuffer.consume();
                }
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        });

        producerThread.start();
        consumeThread.start();
    }
}
