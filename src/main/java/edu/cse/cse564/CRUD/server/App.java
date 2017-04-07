/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cse.cse564.CRUD.server;
import java.util.*;
import java.net.URI;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.ws.rs.FormParam;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author acheruvu
 */
@Path("/")
public class App {
    
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    public static GradeBook gradebook;
    
      @Context
    private UriInfo context;
    
    App()
    {
         LOG.info("Creating an App class");
         gradebook=null;
        
    }
    
    /**
     * This method creates the Student
     */
    @POST
    @Path("/gradebook/student")
    
    public static Response createStudent(@FormParam("StudentID") String sid, @FormParam("StudentName") String sname)
    {
        LOG.info("Creating the instance createStudent {}");
        LOG.debug("POST request");
        LOG.debug("Request Content = {} {} ", sid,sname);
        
        if(sid.equals("")||sname.equals(""))
        {
            return Response.status(Response.Status.BAD_REQUEST).entity("Student Details  are empty").build();
        }
        try
        {
            Student newstudent=new Student();
            newstudent.setStudentID(sid);
            newstudent.setStudentName(sname);
            
            if (gradebook==null)
            {
                gradebook=new GradeBook();
                List<Student> studentlist=new ArrayList<Student>();
                studentlist.add(newstudent);
                gradebook.setStudents(studentlist);
            }
            else
            {
                List<Student> existingstudents=gradebook.getStudents();
                for (Student s:existingstudents)
                {
                    if(s.getStudentID().equals(sid))
                    {
                        String message="Student ID :"+sid+" given already exists";
                        return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
                    }
                }
                    
                    List<GradeItem> existinggradeitems=existingstudents.get(0).getStudentGradeItems();
                    if(existinggradeitems==null)
                    {
                        existingstudents.add(newstudent);
                        gradebook.setStudents(existingstudents);
                    }
                    else
                    {
                        List<GradeItem> newgradeitem=new ArrayList<GradeItem>();
                        for (GradeItem g:existinggradeitems)
                        {
                            g.setFeedback(null);
                            g.setGrade(null);
                            newgradeitem.add(g);
                        }
                        newstudent.setStudentGradeItems(newgradeitem);
                        existingstudents.add(newstudent);
                        gradebook.setStudents(existingstudents);
                    }
                    
                    
                }
                 LOG.debug("CreateStudent Complete");
                String output=new ObjectMapper().writeValueAsString(newstudent);
                return Response.status(Response.Status.CREATED).entity(output).build();
          }
        catch(JsonParseException e) {
                         LOG.debug("CreateStudent Complete");
			return Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch(JsonMappingException e)
        {
             LOG.debug("CreateStudent Complete");
            return Response.status(Response.Status.BAD_REQUEST).build();
            
        }
        catch(IOException e)
        {
             LOG.debug("CreateStudent Complete");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
       
    }
    
    
}
