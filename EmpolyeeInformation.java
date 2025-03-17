
import java.util.ArrayList;
import java.util.Scanner;

class Employee{
    String id;
    String name;
    int salary;

    Employee(String id,String name,int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}


public class EmpolyeeInformation {
    
    public static void printEmployeeDetails(ArrayList<Employee> record){
        for(Employee e : record){
            System.out.println(e.id +"  "+e.name+"  "+e.salary);
        }
        
    }

    public static void addNewEmployee(ArrayList<Employee> record){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the id of employee : ");
                String _id = sc.nextLine();
                System.out.print("Enter the name of employee : ");
                String _name = sc.nextLine();
                System.out.print("Enter the salary of employee : ");
                int _salary = sc.nextInt();

                record.add(new Employee(_id, _name, _salary));
                System.out.println("Employee added Sucessfully.");
    }

    public  static void updateEmployee(ArrayList<Employee> record){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the id : ");
                String empId  = sc.nextLine();
                for(Employee e : record){
                    if(e.id .equals(empId)){
                        System.out.print("Enter the updated name : ");
                        e.name = sc.nextLine();
                        System.out.print("Enter the updated salary : ");
                        e.salary = sc.nextInt();
                        System.out.println("Updated Successfully...");
                        return;
                     }
                    
                 }
                 System.out.println("Employee not exits.\nPlease add this empployee.");
         }

    public static void searchEmployee(ArrayList<Employee> record){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the id : ");
                String _empId  = sc.nextLine();
                for(Employee e : record){
                    String _id = e.id;
                    if(_id.equalsIgnoreCase(_empId)){
                        System.out.println("Employee found : ");
                        System.out.println(e.id +"  "+e.name+"  "+e.salary);
                        System.out.println();
                        return;
                    }
                    
                }
                System.out.println("Employee not exists.");
    }

    public static void removeEmployee(ArrayList<Employee> record){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the id : ");
        String _empId  = sc.nextLine();

        for(Employee e : record){
            
            if(e.id.equals(_empId)){
                int index = record.indexOf(_empId);
                record.remove(index);
            }
        }
        System.out.println("Employee removed successfully...");


    }
    public static void main(String[] args) {
        ArrayList<Employee> record = new ArrayList<Employee>();

        Employee e1 = new Employee("E1237", "Rajnees Verma", 10000);
        Employee e2 = new Employee("E1297", "Arpit Bangar", 90000);
        Employee e3 = new Employee("E1296", "Anshu Saini", 80000);
        Employee e4 = new Employee("E1238", "Manisha Rani", 50000);
        Employee e5 = new Employee("E1233", "Nikhita Singh", 30000);

        record.add(e1);
        record.add(e2);
        record.add(e3);
        record.add(e4);
        record.add(e5);
        
        // printEmployeeDetails(record);

        System.out.println("Select the option : ");
        System.out.println("1. To add new employee.\n2. To update the employee detail.\n3. To search employee.\n4. To remove the employee.");

        int op;
        Scanner sc = new Scanner(System.in);
        op = sc.nextByte();
        
        switch(op){
            case 1 :
                addNewEmployee(record);
                break;

            case 2 :
                updateEmployee(record);
                break;

            case 3 : 
                searchEmployee(record);
                break;
            case 4 : 
                removeEmployee(record);
                break;
            
        }
        printEmployeeDetails(record);

    }
    
}
