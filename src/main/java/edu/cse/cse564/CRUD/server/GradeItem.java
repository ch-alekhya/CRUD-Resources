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
public class GradeItem {
    
    public String GradeID;
    public String Grade;
    public String Feedback;
    public String Percentage;
    
    GradeItem()
    {
        GradeID="";
        Grade=null;
        Feedback=null;
        Percentage="";
    }
    
    public String getGradeID()
    {
        return this.GradeID;
    }
    
    public String getGrade()
    {
        return this.Grade;
    }
    
    public String getFeedback()
    {
        return this.Feedback;
    }
    public String getPercentage()
    {
        return this.Percentage;
    }
    
    public void setGradeID(String id)
    {
        this.GradeID=id;
    }
    
    public void setGrade(String grade)
    {
        this.Grade=grade;
    }
    
    public void setFeedback(String feedback)
    {
        this.Feedback=feedback;
    }
    
    public void setPercentage(String per)
    {
        this.Percentage=per;
    }
    
}
