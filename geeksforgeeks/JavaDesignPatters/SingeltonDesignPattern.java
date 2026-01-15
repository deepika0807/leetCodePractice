package geeksforgeeks.JavaDesignPatters;

public class SingeltonDesignPattern
{
    public static void main(String[] args){
        Singelton obj = Singelton.getInstance();
    }
}
class Singelton{
    private static  Singelton singelton = new Singelton();
    private Singelton(){

    }
    public static Singelton getInstance(){
        return singelton;
    }
}
