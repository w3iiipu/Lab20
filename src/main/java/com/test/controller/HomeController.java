package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class HomeController {

//  this is the welcome page
    @RequestMapping(value = {"/", "welcome"})

    public ModelAndView helloWorld() {
        return new
                ModelAndView("welcome", "message", "");

    }

    @RequestMapping("register")

    public ModelAndView getRegister() {


        return new
                ModelAndView("UserRegistration", "userReg", "Please fill in the form to register!");
    }

    @RequestMapping("processForm")

    public ModelAndView processFormMethod
            (@RequestParam("FName") String FName,
             @RequestParam("LName") String LName,
             @RequestParam("Email") String Email,
             @RequestParam("TelNum") String Tel,
             @RequestParam("PWord") String Password,
             @RequestParam("checkPWord") String cPassword) throws ClassNotFoundException, SQLException {
        if (Password.equals(cPassword)) {       //checks for password and confirm password to be the same before connecting to database server
            String url;
            String username;
            String password;

//          declare url, username and password for database connection
            url = "jdbc:mysql://localhost:3306/GCCoffee";
            username = "GCAdmin";
            password = "boss";

//          2 load and register driver
            Class.forName("com.mysql.jdbc.Driver");

//          3 create connection
            Connection con = DriverManager.getConnection(url, username, password);

//          preparedstatement that pushes entry into database table
            PreparedStatement pst = con.prepareStatement("insert into customers(FirstName, LastName, Email, PhoneNum, Password)" + "values(?,?,?,?,?)");

            pst.setString(1, FName);
            pst.setString(2, LName);
            pst.setString(3, Email);
            pst.setString(4, Tel);
            pst.setString(5, Password);
            pst.executeUpdate();

//          7 close connection
            pst.close();
            con.close();

//          inside of if loop goes onto display confirm page
            return new ModelAndView("confirmPage", "confirmMessage", FName);
        } else {
//          else loop that will re-direct back to user registration page will error message
            return new ModelAndView("UserRegistration", "userReg", "Please Enter a valid password");
        }

    }
}
