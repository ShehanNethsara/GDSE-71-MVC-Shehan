/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.model;

import edu.ijse.dto.CustomerDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import edu.ijse.db.DBConnection;






/**
 *
 * @author user
 */
public class CustomerModel {
    
    
    
    public String saveCustomr(CustomerDto customerDto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Customer VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

       statement.setString(1, customerDto.getId());
       statement.setString(2, customerDto.getTitle());
       statement.setString(3, customerDto.getName());
       statement.setString(4, customerDto.getDob());
       statement.setDouble(5, customerDto.getSalary());
       statement.setString(6, customerDto.getAddress());
       statement.setString(7, customerDto.getCity());
       statement.setString(8, customerDto.getProvince());
       statement.setString(9, customerDto.getPostalCode());
       
       int result = statement.executeUpdate();
       return result > 0? "Successfully" : "Fail";
        
    }
    
}
