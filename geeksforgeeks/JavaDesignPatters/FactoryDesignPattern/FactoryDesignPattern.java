package geeksforgeeks.JavaDesignPatters.FactoryDesignPattern;

public class FactoryDesignPattern
{
    public static void main(String[] args){
        OSFactory osFactory = new OSFactory();
        OS os = osFactory.getInstance("Open");
        os.spec();
    }
}

class OSFactory{
    public OS getInstance(String type){
        if(type.equalsIgnoreCase("Open")){
            return new Android();
        }else if (type.equalsIgnoreCase("Secure")){
            return new IOS();
        }else{
            return new Window();
        }
    }
}

