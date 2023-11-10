import java.io.*;
import java.util.*;

class student implements Serializable{
    private String name;
    private int roll_no;
    private String grade;

    public student(String name, int roll_no, String grade){
        this.name = name;
        this.roll_no = roll_no;
        this.grade = grade;
    }

    public String getname(){
        return name;
    }

    public void setname(String name){
        this.name = name;
    }

    public int getroll_no(){
        return roll_no;
    }

    public void setroll_no(int roll_no){
        this.roll_no = roll_no;
    }

    public String getgrade(){
        return grade;
    }

    public void setgrade(String grade){
        this.grade = grade;
    }

    public String toString(){
        return "Name: "+ name + ",Roll_no: "+ roll_no + ",Grade: "+ grade;
    }

}

class InnerSMS{

    private List<student> Students = new ArrayList<>();

    public void addstudent(student Student){
        Students.add(Student);
    }

    public void removestudent(int roll_no){
        Students.removeIf(Student -> Student.getroll_no() == roll_no);
    }

    public student SearchstudentByname(String name){
        for(student s : Students){
            if(s.getname().equalsIgnoreCase(name)){
                return s;
            }
        }
        return null;
    }

    public List<student>getallstudents(){
        return Students;
    }

    public void writestudentData()
    throws Exception{
        File file = new File("Students.txt");
        ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(file));
            OOS.writeObject(Students);
    } 
    public void readstudentData()
    throws Exception{
        File file = new File("Students.txt");
        ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(file));
        student Students = (student)OIS.readObject();
        
        System.out.println(Students);
        
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        InnerSMS system = new InnerSMS();

       // system.readstudentData();

        while(true){
            System.out.println("\nStudent Management System");
            System.out.println("1.Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search a student");
            System.out.println("4. Dispiay a student");
            System.out.println("5. Exit");

            System.out.println("Enter your chossen number: ");
            int choice = sc.nextInt();
          //  sc.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Enter student's name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student's roll_no: ");
                    int roll_no = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student's grade: ");
                    String grade = sc.nextLine();

                    if(roll_no > 0){
                        student nStudent = new student (name, roll_no, grade);
                        system.addstudent(nStudent);
                        System.out.println("Student added successfully.");
                    }
                    else{
                        System.out.println("Invalid roll_no.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the roll no to remove the student: ");
                    int rollToRemove = sc.nextInt();
                    sc.nextLine();
                    system.removestudent(rollToRemove);
                    System.out.println("Student removed successfully.");
                    break;
                case 3:
                    System.out.println("Enter the name of the student to search: ");
                    String nameToSearch = sc.nextLine();
                    sc.nextLine();
                    student foundstudent = system.SearchstudentByname(nameToSearch);
                    if(foundstudent != null){
                        System.out.println("Student found:" + foundstudent);    
                    }
                    else{
                        System.out.println("Student not found");
                    }
                    break;
                    
                case 4: 
                    List <student> allStudents = system.getallstudents();
                    if(allStudents.isEmpty()){
                        System.out.println("No student in the system.");
                    }
                    else{
                        System.out.println("All Students: ");
                        for(student Students : allStudents){
                            System.out.println(Students);
                        }
                    }
                    break;
                case 5: 
                    system.writestudentData();
                    System.out.println("student data saved. Exiting the program.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice."); 
                    
            }
        }
        
    }
    
}
