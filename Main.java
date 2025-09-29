import java.io.*;
import java.util.*;

class Student implements Serializable {
private int studentID;
private String name;
private double grade;

public Student(int studentID, String name, double grade) {
this.studentID = studentID;
this.name = name;
this.grade = grade;
}

public void display() {
System.out.println("Student ID: " + studentID);
System.out.println("Name      : " + name);
System.out.println("Grade     : " + grade);
}
}

class Employee {
private int id;
private String name;
private String designation;
private double salary;

public Employee(int id, String name, String designation, double salary) {
this.id = id;
this.name = name;
this.designation = designation;
this.salary = salary;
}

@Override
public String toString() {
return id + "," + name + "," + designation + "," + salary;
}

public static Employee fromString(String line) {
String[] parts = line.split(",");
return new Employee(
Integer.parseInt(parts[0]),
parts[1],
parts[2],
Double.parseDouble(parts[3])
);
}

public void display() {
System.out.printf("ID: %d | Name: %s | Designation: %s | Salary: %.2f\n", id, name, designation, salary);
}
}

public class Main{
private static final String EMPLOYEE_FILE = "employees.txt";
private static final String STUDENT_FILE = "student.ser";

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int mainChoice;

do {
System.out.println("\nMain Menu");
System.out.println("1. Sum of Integers (Autoboxing)");
System.out.println("2. Serialize Student");
System.out.println("3. Deserialize Student");
System.out.println("4. Employee Management System");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");
mainChoice = scanner.nextInt();
scanner.nextLine();

switch (mainChoice) {
case 1:
sumOfIntegers(scanner);
break;
case 2:
serializeStudent();
break;
case 3:
deserializeStudent();
break;
case 4:
employeeMenu(scanner);
break;
case 5:
System.out.println("Exiting application.");
break;
default:
System.out.println("Invalid choice.");
}
} while (mainChoice != 5);

scanner.close();
}

private static void sumOfIntegers(Scanner scanner) {
System.out.println("Enter integers separated by space:");
String input = scanner.nextLine();
String[] tokens = input.trim().split("\\s+");
ArrayList<Integer> numbers = new ArrayList<>();
for (String token : tokens) {
Integer number = Integer.parseInt(token);
numbers.add(number);
}
int sum = 0;
for (Integer num : numbers) {
 sum += num;
}
System.out.println("Sum of integers: " + sum);
}

private static void serializeStudent() {
Student student = new Student(101, "Alice", 88.5);
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE))) {
oos.writeObject(student);
 System.out.println("Student serialized successfully.");
} catch (IOException e) {
e.printStackTrace();
}
}

private static void deserializeStudent() {
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STUDENT_FILE))) {
Student student = (Student) ois.readObject();
System.out.println("Deserialized Student:");
student.display();
} catch (IOException | ClassNotFoundException e) {
e.printStackTrace();
}
}


private static void employeeMenu(Scanner scanner) {
int choice;
do {
System.out.println("\nEmployee Menu");
System.out.println("1. Add Employee");
System.out.println("2. Display All Employees");
System.out.println("3. Back to Main Menu");
System.out.print("Enter your choice: ");
choice = scanner.nextInt();
scanner.nextLine();
switch (choice) {
case 1:
addEmployee(scanner);
break;
case 2:
displayEmployees();
break;
case 3:
break;
default:
System.out.println("Invalid choice.");
}
} while (choice != 3);
}

private static void addEmployee(Scanner scanner) {
try {
System.out.print("Enter ID: ");
int id = scanner.nextInt();
scanner.nextLine();
System.out.print("Enter Name: ");
String name = scanner.nextLine();
System.out.print("Enter Designation: ");
String designation = scanner.nextLine();
System.out.print("Enter Salary: ");
double salary = scanner.nextDouble();
Employee emp = new Employee(id, name, designation, salary);
try (BufferedWriter writer = new BufferedWriter(new FileWriter(EMPLOYEE_FILE, true))) {
writer.write(emp.toString());
writer.newLine();
System.out.println("Employee added.");
}
} catch (IOException e) {
System.out.println("Error writing file.");
}
}

private static void displayEmployees() {
try (BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_FILE))) {
String line;
System.out.println("\n--- Employee Records ---");
while ((line = reader.readLine()) != null) {
Employee emp = Employee.fromString(line);
emp.display();
}
} catch (IOException e) {
System.out.println("Error reading file.");
}
}
}
                                                    
                                                                                          
                                                    
                                        
                                                
                                                                                                                                                                                      
                                                
                                   
                                                                                                                                                       
                                                   
                              
                                        
                                       
                            
                                           
                                           
                        
                                                                               
                                                               
                    
                                                                                                                                                                       
                                            
                

                                        
                                                   
                                   
                            
                        

                       
                 



    
