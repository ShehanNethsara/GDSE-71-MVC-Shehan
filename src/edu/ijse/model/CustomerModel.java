
package edu.ijse.model;

import edu.ijse.dto.CustomerDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import edu.ijse.db.DBConnection;


public class CustomerModel {
    
    
    
    public String saveCustomr(CustomerDto customerDto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "Update  Customer SET CustTitle = ? ,CusName = ?,DOB = ?,salary = ?,CustAddress = ?, City = ?, Province =?, PostalCode =? WHERE CustID";
        PreparedStatement statement = connection.prepareStatement(sql);

      
       statement.setString(1, customerDto.getTitle());
       statement.setString(2, customerDto.getName());
       statement.setString(3, customerDto.getDob());
       statement.setDouble(4, customerDto.getSalary());
       statement.setString(5, customerDto.getAddress());
       statement.setString(6, customerDto.getCity());
       statement.setString(7, customerDto.getProvince());
       statement.setString(8, customerDto.getPostalCode());
       statement.setString(9, customerDto.getId());
       
       int result = statement.executeUpdate();
       return result > 0? "Successfully Update" : "Fail";
        
    }
    
}
