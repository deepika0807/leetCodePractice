package geeksforgeeks;

public class GlobalExceptionDemo
{
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(
                (thread, exception) -> {
                    System.out.println("Global handler caught exception in thread "
                            + thread.getName() + ": " + exception);
                }
        );

        Thread t1 = new Thread(() -> method1(), "Worker-1");
        Thread t2 = new Thread(() -> method2(), "Worker-2");

        t1.start();
        t2.start();
    }

    static void method1() {
        int x = 10 / 0;
    }

    static void method2() {
        String str = null;
        System.out.println(str.toUpperCase());
    }
}
