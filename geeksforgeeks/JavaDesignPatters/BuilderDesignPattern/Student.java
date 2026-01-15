package geeksforgeeks.JavaDesignPatters.BuilderDesignPattern;

public class Student
{
    private String studentName;

    private Integer rollNo;
    private String universityName;

    private  String city;

    public Student(String studentName, Integer rollNo, String universityName, String city)
    {
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.universityName = universityName;
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "Student{" + "studentName='" + studentName + '\'' + ", rollNo=" + rollNo + ", universityName='"
                + universityName + '\'' + ", city='" + city + '\'' + '}';
    }
}
