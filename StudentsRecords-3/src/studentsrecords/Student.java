/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsrecords;

/**
 *
 * @author Francesco Rubino
 */
public class Student {
    private int idNumber;
    private String studentName;
    private String studentEamil;
    private int yearOfStudy;
    private Module modules[] = new Module[4];

    public int getIdNumber() {
        return idNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setModules(Module[] modules) {
        this.modules = modules;
    }

    public Module[] getModules() {
        return modules;
    }

    public String getStudentEamil() {
        return studentEamil;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentEamil(String studentEamil) {
        this.studentEamil = studentEamil;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    
    
    
    
}
