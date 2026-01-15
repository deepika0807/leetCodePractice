package geeksforgeeks.JavaDesignPatters.BuilderDesignPattern;

public class StudentBuilder
{
    private String studentName;

    private Integer rollNo;
    private String universityName;

    private  String city;

    public StudentBuilder setStudentName(String studentName)
    {
        this.studentName = studentName;
        return this;
    }

    public StudentBuilder setRollNo(Integer rollNo)
    {
        this.rollNo = rollNo;
        return this;
    }

    public StudentBuilder setUniversityName(String universityName)
    {
        this.universityName = universityName;
        return this;
    }

    public StudentBuilder setCity(String city)
    {
        this.city = city;
        return this;
    }

    public Student builder(){
        return new Student(studentName, rollNo, universityName, city);
    }
}
