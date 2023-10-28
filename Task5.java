import java.util.*;

//class Student{
//    private String name;
//    private int rollno;
//    private int grade;
//    public Student(String name, int rollno, int grade){
//        this.name = name;
//        this.rollno = rollno;
//        this.grade = grade;
//    }
//
//    public String getName(){
//        return name;
//    }
//
//    public int getRollno() {
//        return rollno;
//    }
//
//    public int getGrade() {
//        return grade;
//    }
//}
//
//class StudentManagementSystem{
//ArrayList<Student> stu = new ArrayList<Student>();
//public void addStudent(Student s){
//    stu.add(s);
//}
//
//public boolean removeStudent(int rno){
//    for(Student student : stu){
//        if(student.getRollno() == rno){
//            stu.remove(student);
//            return true;
//        }
//    }
//    return false;
//}
//
//public Student searchStudent(int rollnumber){
//    for (Student student : stu) {
//        if(student.getRollno() == rollnumber)
//            return student;
//    }
//    return null;
//}
//
//public void displayAllStudents(){
//    for(Student student : stu){
//        System.out.println("Roll No. : "+student.getRollno()+"\t\tName : "+student.getName()+"\t\tGrade : "+student.getGrade());
//    }
//}
//}
//public class Task5 {
//    public static void main(String[] args) {
//        StudentManagementSystem sms = new StudentManagementSystem();
//        Scanner sc = new Scanner(System.in);
//        while(true){
//            System.out.println("Student Management System");
//            System.out.println("1. Add student");
//            System.out.println("2. Remove student");
//            System.out.println("3. Search student");
//            System.out.println("4. Display all students");
//            System.out.println("5. Exit");
//            System.out.println("Enter your choice : ");
//            int ch = sc.nextInt();
//            sc.nextLine();
//            switch (ch){
//                case 1 :
//                    System.out.println("Enter student name : ");
//                    String name = sc.nextLine();
//                    System.out.println("Enter student roll number : ");
//                    int rollno = sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Enter student grade : ");
//                    int grade = sc.nextInt();
//                    sc.nextLine();
//                    Student s = new Student(name, rollno, grade);
//                    sms.addStudent(s);
//                    System.out.println("Student added successfully!!");
//                    break;
//
//                case 2 :
//                    System.out.println("Enter the roll no of the student you want to remove : ");
//                    int rno = sc.nextInt();
//                    if(sms.removeStudent(rno)){
//                        System.out.println("Student removed successfully!!");
//                    }
//                    else
//                        System.out.println("Student with "+rno+" roll no. does not exist.");
//                    break;
//
//                case 3:
//                    System.out.println("Enter the roll no of the student you want to search : ");
//                    int rollnumber = sc.nextInt();
//                    Student found = sms.searchStudent(rollnumber);
//                    if(found != null){
//                        System.out.println("Student found");
//                    }
//                    else{
//                        System.out.println("Student not found");
//                    }
//                    break;
//
//                case 4:
//                    sms.displayAllStudents();
//                    break;
//
//                case 5:
//                    System.out.println("Exiting the application. Goodbye!!");
//                    System.exit(0);
//                    break;
//
//                default:
//                    System.out.println("Invalid choice!!");
//                    break;
//            }
//        }
//
//    }
//}
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
class Student{
    private String name;
    private int rollno;
    private int grade;
    public Student(String name, int rollno, int grade){
        this.name = name;
        this.rollno = rollno;
        this.grade = grade;
    }

    public String getName(){
        return name;
    }

    public int getRollno() {
        return rollno;
    }

    public int getGrade() {
        return grade;
    }
}

class StudentManagementSystem{
    ArrayList<Student> stu = new ArrayList<Student>();

    public void addStudent(Student s){
        stu.add(s);
        Storing_value_in_file();
    }

    public boolean removeStudent(int rno){
        for(Student student : stu){
            if(student.getRollno() == rno){
                stu.remove(student);
                Storing_value_in_file();
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(int rollnumber){
        for (Student student : stu) {
            if(student.getRollno() == rollnumber)
                return student;
        }
        return null;
    }

    public void displayAllStudents(){
        for(Student student : stu){
            System.out.println("Roll No. : "+student.getRollno()+"\t\tName : "+student.getName()+"\t\tGrade : "+student.getGrade());
        }
        System.out.println();
    }
            //DATABASE/
    //Storing values in a file
    public void Storing_value_in_file() {
        File myFile = new File("Task5.txt");
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Unable to create this file\n");
            e.printStackTrace();
        }

        try {
            FileWriter filewrite = new FileWriter("Task5.txt");
            filewrite.write("Student Details:\n");
            for(Student student : stu){
                filewrite.write("Roll No. : "+student.getRollno()+"\t\tName : "+student.getName()+"\t\tGrade : "+student.getGrade()+"\n");
            }
            filewrite.close();
        } catch (Exception e) {
            System.out.println("Unable to write in a file\n");
        }
    }

    //    Deleting a File
    public  void Deleting_file()
    {
        File myfile = new File("Task5.txt");

        if(myfile.delete())
        {
            System.out.println("I have deleted: "+myfile.getName()+"\n");
        }
        else {
            System.out.println("file not found!!\n");
        }
    }

    //Reading a File
    public void Reading_a_file()
    {
        File myfile=new File("Task5.txt") ;
        try{
            Scanner sc = new Scanner(myfile);
            while (sc.hasNextLine())
            {
                String line =sc.nextLine();
                System.out.println(line);
            }
            System.out.println();
            sc.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("file not found!!\n");
//            e.printStackTrace();
        }
    }
}
public class Task5 {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Student Management System");
        HashSet<Integer> hs=new HashSet<>();
        while(true){
            System.out.println("Enter");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Search student");
            System.out.println("4. Display all students");
            System.out.println("5. Reading a File");
            System.out.println("6. Deleting a File");
            System.out.println("7. Exit");
            System.out.println("Enter your choice : ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch){
                case 1 :
                    System.out.println("Enter student name : ");
                    String name = sc.nextLine();

                    System.out.println("Enter student roll number : ");
                    int rollno = sc.nextInt();
                    sc.nextLine();
                    if(hs.contains(rollno))
                    {
                        System.out.println("Student with same roll number already exists!");
                        break;
                    }
                    hs.add(rollno);
                    System.out.println("Enter student grade : ");
                    int grade = sc.nextInt();
                    sc.nextLine();
                    Student s = new Student(name, rollno, grade);
                    sms.addStudent(s);
                    System.out.println("Student added successfully!!");
                    break;

                case 2 :
                    System.out.println("Enter the roll no of the student you want to remove : ");
                    int rno = sc.nextInt();
                    if(sms.removeStudent(rno)){
                        hs.remove(rno);
                        System.out.println("Student removed successfully!!");
                    }
                    else
                        System.out.println("Student with "+rno+" roll no. does not exist.");
                    break;

                case 3:
                    System.out.println("Enter the roll no of the student you want to search : ");
                    int rollnumber = sc.nextInt();
                    Student found = sms.searchStudent(rollnumber);
                    if(found != null){
                        System.out.println("Student found");
                    }
                    else{
                        System.out.println("Student not found");
                    }
                    break;

                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    sms.Reading_a_file();
                    break;
                case 6:
                    sms.Deleting_file();
                    break;
                case 7:
                    System.out.println("Exiting the application. Goodbye!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!!");
            }
        }
    }
}