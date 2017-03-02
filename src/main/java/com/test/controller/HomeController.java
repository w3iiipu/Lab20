package com.test.controller;

import com.test.model.Inventory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

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

    public ArrayList<Inventory> getInventory() {
        String selectInventory = "select itemid, name, description, quantity, price from items";
        String url = "jdbc:mysql://localhost:3306/GCCoffee";
        String userName = "root";
        String password = "admin";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, userName, password);

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(selectInventory);

            ArrayList<Inventory> inventoryList = new ArrayList<Inventory>();
            while (rs.next()) {
                String ItemID = rs.getString(1);
                String Name = rs.getString(2);
                String Description = rs.getString(3);
                int Quantity = rs.getInt(4);
                BigDecimal Price = rs.getBigDecimal(5);

                Inventory temp = new Inventory(ItemID, Name, Description, Quantity, Price);

                inventoryList.add(temp);
            }
            return inventoryList;
        }
        catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping("DisplayItems")
    public ModelAndView viewInventory() {
        ArrayList<Inventory> inventoryList = getInventory();
        return new
                ModelAndView("DisplayItems", "cInventory", inventoryList);

    }

//    @RequestMapping("processItem")
//
//    public ModelAndView processItemMethod
//            (
//             @RequestParam("ItemName") String ItemName,
//             @RequestParam("Desc") String Description,
//             @RequestParam("Quantity") String Quantity,
//             @RequestParam("RPrice") String RPrice,
//             @RequestParam("CPrice") String CPrice) throws ClassNotFoundException, SQLException {
//
//            String url;
//            String username;
//            String password;
//
//            url = "jdbc:mysql://localhost:3306/GCCoffee";
//            username = "GCAdmin";
//            password = "boss";
//
//            Class.forName("com.mysql.jdbc.Driver");
//
//            Connection con = DriverManager.getConnection(url, username, password);
//
//            PreparedStatement pst = con.prepareStatement("insert into items(Name, Description, Quantity, Price, Cost)" + "values(?,?,?,?,?)");
//
//            pst.setString(1, ItemName);
//            pst.setString(2, Description);
//            pst.setString(3, Quantity);
//            pst.setString(4, RPrice);
//            pst.setString(5, CPrice);
//            pst.executeUpdate();
//
////          7 close connection
//            pst.close();
//            con.close();
//
//            ArrayList<Inventory> inventoryList = getInventory();
//
////          inside of if loop goes onto display confirm page
//            return new ModelAndView("DisplayItems", "cInventory", inventoryList);
//        }

}

