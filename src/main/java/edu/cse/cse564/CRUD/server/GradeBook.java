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
public class GradeBook {
    
    List<Student> Students;
    
    GradeBook()
    {
        Students=null;
    }
    
    public List<Student> getStudents()
    {
        return this.Students;
    }
    
    public void setStudents(List<Student> Students)
    {
        this.Students=Students;
    }
    
}
