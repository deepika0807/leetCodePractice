package geeksforgeeks;

public class CompartorAndComparable
{
    public static void main(String[] args)
    {

    }
}

class Employee implements Comparable<Employee>{

    public String EmpName;
    @Override
    public int compareTo(Employee emp)
    {
        if( this.EmpName.equals(emp.EmpName)){
            return 0;
        }
        return 0;

    }
}
