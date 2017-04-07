/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cse.cse564.CRUD.server;

import java.util.*;

/**
 *
 * @author acheruvu
 */
public class Student {
    
    private String StudentName;
    private String StudentID;
    private List<GradeItem> StudentGradeItems;
    
    Student()
    {
        StudentName="";
        StudentID="";
        StudentGradeItems=null;
    }
    
    public String getStudentName()
    {
        return this.StudentName;
    }
    
    public String getStudentID()
    {
        return this.StudentID;
    }
    
    public List<GradeItem> getStudentGradeItems()
    {
        return this.StudentGradeItems;
    }
    
    public void setStudentName(String name)
    {
        this.StudentName=name;
    }
    
    public void setStudentID(String id)
    {
        this.StudentID=id;
    }
    
    public void setStudentGradeItems(List<GradeItem> items)
    {
        this.StudentGradeItems=items;
    }
    
}
