package geeksforgeeks.JavaDesignPatters.FactoryDesignPattern;

import geeksforgeeks.JavaDesignPatters.FactoryDesignPattern.OS;

public class Window implements OS
{
    @Override
    public void spec(){
        System.out.println("Windows class");
    }
}