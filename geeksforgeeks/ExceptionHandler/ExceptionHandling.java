package geeksforgeeks.ExceptionHandler;

public class ExceptionHandling
{
    public static void main(String[] args)
    {
        try {
            String s = null;
            System.out.println(s.length());
        }
        catch (NullPointerException e) {   // ✅ specific first
            System.out.println("Null Pointer");
        }
        catch (Exception e) {              // ✅ general last
            System.out.println("General exception");
        }

        System.out.println("Hello Wrold!");
            int a = testFunc();
            System.out.println(a);

Thread thread =  new Thread(()-> {});
    }

    public static int testFunc(){
        try{
            String a = null;
            System.out.println(a.equals("test"));
        }catch (NullPointerException e){
            System.out.println(e.getMessage()); // prints null
        }
        return 1;
    }
}
