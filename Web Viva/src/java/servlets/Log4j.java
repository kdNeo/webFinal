/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

/**
 *
 * @author Kaveesha Nadun
 */
public class Log4j extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
      
           
        
   
    }
     public static void loging (String appPath,String user){
         
        //  System.out.println(e.getMessage());
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(appPath+"//x.txt", true));
            out.write(new Date().toString() + " -- " + user + "\n");
            out.flush();
            out.close();
        } catch (IOException ex) {

 //JOptionPane.showMessageDialog(null, "Couldn't log exception!\nPlease contact support. \n" + ex.getMessage(), "Ooops!", JOptionPane.WARNING_MESSAGE);
        }

     }
      public static void resetpw (String appPath,String user,String pw){
         
        //  System.out.println(e.getMessage());
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(appPath+"//x.txt", true));
            out.write(new Date().toString() + " -- " +" customer email:"+ user +" "+"customer changed password:"+ pw + "\n");
            out.flush();
            out.close();
        } catch (IOException ex) {

 //JOptionPane.showMessageDialog(null, "Couldn't log exception!\nPlease contact support. \n" + ex.getMessage(), "Ooops!", JOptionPane.WARNING_MESSAGE);
        }

     }
     public static void signup (String appPath,String user,String pww){
         
        //  System.out.println(e.getMessage());
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(appPath+"//x.txt", true));
            out.write(new Date().toString() + " -- " +"A new customer signup in to the system:"+ user +"His Password:"+ pww + "\n");
            out.flush();
            out.close();
        } catch (IOException ex) {

 //JOptionPane.showMessageDialog(null, "Couldn't log exception!\nPlease contact support. \n" + ex.getMessage(), "Ooops!", JOptionPane.WARNING_MESSAGE);
        }

     }
      public static void order (String appPath,Integer id,String user ){
         
        //  System.out.println(e.getMessage());
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(appPath+"//x.txt", true));
            out.write(new Date().toString() + " -- " +"Invoice Id:"+ id +" "+"Customer Name:"+user+ "\n");
            out.flush();
            out.close();
        } catch (IOException ex) {

 //JOptionPane.showMessageDialog(null, "Couldn't log exception!\nPlease contact support. \n" + ex.getMessage(), "Ooops!", JOptionPane.WARNING_MESSAGE);
        }

     }
      
       public static void exceptionss (String appPath,String user ){
         
        //  System.out.println(e.getMessage());
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(appPath+"//x.txt", true));
            out.write(new Date().toString() + " -- " +user+ "\n");
            out.flush();
            out.close();
        } catch (IOException ex) {

 //JOptionPane.showMessageDialog(null, "Couldn't log exception!\nPlease contact support. \n" + ex.getMessage(), "Ooops!", JOptionPane.WARNING_MESSAGE);
        }

     }

   
    
}
