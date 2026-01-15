package geeksforgeeks.JavaDesignPatters.BuilderDesignPattern;

class BuilderDesignPattern
{
    public static void main(String[] args)
    {
        Student student = new StudentBuilder().setStudentName("Test").setRollNo(1).builder();
        System.out.println(student);
    }

}
