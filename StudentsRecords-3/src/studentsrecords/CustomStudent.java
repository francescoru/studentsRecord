/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsrecords;


import java.util.Scanner;

/**
 *
 * @author Francesco Rubino
 */
public class CustomStudent {
    
    private static StudentArrayList<Student> students = new StudentArrayList<Student>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // sacnner object to read the input from the user
        Scanner scanner = new Scanner(System.in);
        // string to read the user inpt in
        String input = "";
        
        //keep reading the input from the user until the user types in the 0 to exit. 
    while(!input.equals("0")) {
        
        //if the user types 1 then we need to add a new student. 
        if(input.equals("1")){
            Student newStudent = addStudentInSystem();
            students.add(newStudent);
            System.out.println("The student has been added into the system.");
        }
        
        //if the user types 1 then we need to get the student based on the id entered by the user. 
        if(input.equals("2")){
            System.out.print("Please enter ID of the student you are looking for: ");
            String studentId  = scanner.nextLine();
            printStudentsDetails(studentId);
        }
        
        //if the user types 1 then we need to delete the student based on the id entered by the user. 
        if(input.equals("3")){
            System.out.print("Please enter ID of the student you want to delete: ");
            String studentId  = scanner.nextLine();
            deleteStudent(studentId);
        }
        
        //if the user types 1 then we need to view all the student present in the list. 
        if(input.equals("4")){
            viewAllStudents();
        }
        
        //if the user types 1 then we need to add a new module for a student. based on queue the module will be added at the end of the module array. 
        if(input.equals("5")){
            System.out.print("Please enter ID of the you want to add module for: ");
            String studentId  = scanner.nextLine();
            addModuleToStudent(studentId);
        }
        
        //if the user types 1 then we need to print details of a student
        if(input.equals("6")){
            System.out.print("Please enter ID of the student you want to print details for: ");
            String studentId  = scanner.nextLine();
            printSortedStudents(studentId);
        }
        
        //give options to the user. 
        System.out.print("Please select an option and press Enter");
        System.out.println();
        
        System.out.print("1 to Add a new Student");
        System.out.println();
        
        System.out.print("2 to Get a student's record by ID");
        System.out.println();
        
        System.out.print("3 to Delete a student's record by ID");
        System.out.println();
        
        System.out.print("4 to View existing Students records");
        System.out.println();
        
        System.out.print("5 to Add a Module to Student's record by student ID");
        System.out.println();
        
        System.out.print("6 to View a student's module details sorted by marks by student ID");
        System.out.println();
        
        System.out.print("0 to Exit");
        System.out.println();

        input = getValidInput();
    }
    }

    private static String getValidInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try{
            int inputNumber = Integer.parseInt(input);
            if(inputNumber >= 0 && inputNumber < 7){
                return input;
            } else {
                System.out.println("The input is not valid. please try again:");
                return getValidInput();
            }
            
        } catch(Exception exp){
            System.out.println("The input is not valid. please try again:");
            return getValidInput();
        }
    }
  
    private static boolean senatizeInput(String input){
          try{
            int inputNumber = Integer.parseInt(input);
            return true;
          } catch (Exception exp){
              return false;
          }
          
    }
    
     private static Student addStudentInSystem(){
        // scanner object to read user input 
        Scanner scanner = new Scanner(System.in);
        newLine();
        
        System.out.print("Please enter the student ID: ");
        String studentID = scanner.nextLine();
        
        System.out.print("Please enter the student name: ");
        String studentName = scanner.nextLine();
        
        System.out.print("Please enter the student email: ");
        String studentEmail = scanner.nextLine();
        
        System.out.print("Please enter the student year of study: ");
        String studentYearOfStudy = scanner.nextLine();
        
        //create a new Student object to be added into the list. 
        Student student = new Student();
        
        //set all values for that object. 
        student.setIdNumber(Integer.parseInt(studentID));
        student.setStudentName(studentName);
        student.setStudentEamil(studentEmail);
        student.setYearOfStudy(Integer.parseInt(studentYearOfStudy));
        
        //create an array of Module of size 4
        Module modules[] = new Module[4];
        newLine();
        System.out.println("Please provide module details for the student");
        
        //run a loop four time to read the values for module from the user
        for (int i = 1 ; i < 5 ; i++){
            //read from user the value for a module 1 at a time. 
            System.out.print("Name of Module number "+ i +" : " );
            String moduleName = scanner.nextLine();
            System.out.print("Marks in Module "+ moduleName +" : " );
            String marks = scanner.nextLine();
            
            //create a Module object to be added into modules array
            Module module = new Module();
            
            //set the module object's values. 
            module.setModuleName(moduleName);
            module.setModuleMarks(Integer.parseInt(marks));
            
            //add module to the array. 
            modules[i-1] = module;
        }
        
        //add the modules array into the student object. 
        student.setModules(modules);
        newLine();
        newLine();
        newLine();
        return student;
               
    }
    
    public static void printStudentsDetails(String studentId){
        newLine();
        boolean found =false;
        //loop through the students list and print each student. 
        for(int i = 0 ; i < students.size() ; i++){
            Student student = students.get(i);
           if(student.getIdNumber() == Integer.parseInt(studentId)){
               found = true;
               printDetails(student);
               break;
           } 
        }
        if(!found){
            System.out.println("Student with id: " + studentId + " not found");
        }
        newLine();
        newLine();
        newLine();
        
    }
    
    private static void printDetails(Student student){
        //print the details of the stduent. 
        System.out.println("Student ID    : " + student.getIdNumber());
        System.out.println("Student Name  : " + student.getStudentName());
        System.out.println("Student Email : " + student.getStudentEamil());
        System.out.println("Student Year  : " + student.getYearOfStudy());
        System.out.println("Student Modules : ");
        for (int i = 1 ; i < 5 ; i++){
            System.out.println("Module Name: "+ student.getModules()[i-1].getModuleName() + 
                    "    Marks : " + student.getModules()[i-1].getModuleMarks() );
        }
    }
    
    private static void newLine(){
        //print a new line on the console
        System.out.println();
    }
    
    private static void deleteStudent(String studentId){
        // function to delete teh student. 
        newLine();
        for(int i = 0 ; i < students.size() ; i++){
            Student student = students.get(i);
           if(student.getIdNumber() == Integer.parseInt(studentId)){
               students.remove(student);
               break;
           } 
        }
        System.out.println("Student with ID " + studentId +  " is deleted.");
        newLine();
        newLine();
        newLine();
    }
    
    private static void viewAllStudents(){
        //function to view all students. 
        if(students.size() == 0){
            System.out.println("There are no students in the system.");
        }
         for(int i = 0 ; i < students.size() ; i++){
            Student student = students.get(i);
            printDetails(student);
        }
        
        newLine();
        newLine();
        newLine();
    }
    
    private static void addModuleToStudent(String studentId){
        //scanner to add the new module. 
        Scanner scanner = new Scanner(System.in);
        Student requiredStudent = null;
        for(int i = 0 ; i <students.size() ; i++){
            //go throught the students list to find out which student to add the modules for. 
            if(students.get(i).getIdNumber() == Integer.parseInt(studentId)){
                //get the required student. 
                requiredStudent = students.get(i);
                //ask user to put in the new module name and marks. 
                System.out.print("Enter the module name: ");
                String moduleName = scanner.nextLine();
                System.out.print("Enter the Marks: ");
                String marks = scanner.nextLine();
                //create a new module to be added into the modules of that student. 
                Module module = new Module();
                //set the properties of the module. 
                module.setModuleName(moduleName);
                module.setModuleMarks(Integer.parseInt(marks));
                //create a new array to reset the modules for the student. 
                // we will be move each module for the student one position up in the array
                // and add the new module at index 3 of the module array. 
                Module modules[] = new Module[4];
                modules[0] = requiredStudent.getModules()[1];
                modules[1] = requiredStudent.getModules()[2];
                modules[2] = requiredStudent.getModules()[3];
                // adding a new module at index 3 of the modules array
                modules[3] = module;
                //set the moduels for the student. 
                requiredStudent.setModules(modules);
                students.set(i, requiredStudent);
                System.out.println("The student details are updated");
                break;
            }
        }
        newLine();
        newLine();
        
    }
    
    private static void printSortedStudents(String studentId){
        //print the sorted marks for modudes for the student. 
         for(int i = 0 ; i < students.size() ; i++){
             //go therough the students list and get the required student. 
            Student student = students.get(i);
            if(student.getIdNumber() == Integer.parseInt(studentId)){
                printModules(student);
            }
        }
    }
    
    private static void printModules(Student student){
        //create a modules array to store the sorted modules. 
        Module tempModules[] = new Module[4];
       // copy student modules array into this new array. 
        System.arraycopy( student.getModules(), 0, tempModules, 0, student.getModules().length );
        //insertion sort algorithm. 
        for (int j=1; j < tempModules.length; j++) {
            Module tempModule = tempModules[j];
            int i;
            for (i = j - 1; i >= 0 && tempModule.getModuleMarks() > tempModules[i].getModuleMarks() ; i--){
                tempModules[i + 1] = tempModules[i];
            }
             tempModules[i+1] = tempModule;
               
        }
        
        //print out the sorted moduels. 
        for(Module thisModule : tempModules){
            System.out.println("Module name: " + thisModule.getModuleName() + "  Marks: " + thisModule.getModuleMarks());
        }
    }
    
}
