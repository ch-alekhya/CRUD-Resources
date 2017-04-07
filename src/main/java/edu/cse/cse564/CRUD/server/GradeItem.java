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
    
    public void setGradeID(String GradeID)
    {
        this.GradeID=GradeID;
    }
    
    public void setGrade(String Grade)
    {
        this.Grade=Grade;
    }
    
    public void setFeedback(String Feedback)
    {
        this.Feedback=Feedback;
    }
    
    public void setPercentage(String Percentage)
    {
        this.Percentage=Percentage;
    }
    
}
