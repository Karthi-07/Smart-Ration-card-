package ration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCAccess {
		
	public int insertration(NewRegister nr) {
		String databaseURL = "jdbc:ucanaccess:///C://Users//rocks//Documents//ration.accdb";
        
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
        	
        	String sql = "INSERT INTO rationcard (ld_name, ld_age, ld_aadhar, no_of_per ,gender, phoneno, doorno,street,district,state,city,pincode,cardtype) VALUES (?, ?, ?,?,?,?,?, ?, ?,?,?,?,?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,nr.ft_name.getText() );
            preparedStatement.setInt(2, Integer.parseInt(nr.ft_age.getText()));
            preparedStatement.setInt(3,Integer.parseInt(nr.ft_aadhar.getText()) );
            preparedStatement.setInt(4,0 );
            String t = "";
            if(nr.b1.isSelected()) {
            	t="M";
            }else if(nr.b2.isSelected()) {
            	t="F";
            }else if(nr.b3.isSelected()) {
            	t="O";
            }
            preparedStatement.setString(5,t );
            preparedStatement.setString(6,nr.ft_no.getText());
            preparedStatement.setInt(7,Integer.parseInt(nr.ft_doorno.getText()) );
            preparedStatement.setString(8,nr.ft_street.getText());
            preparedStatement.setString(9,nr.ft_district.getText() );
            preparedStatement.setString(10,nr.ft_state.getText());
            preparedStatement.setString(11,nr.ft_city.getText());
            preparedStatement.setInt(12,Integer.parseInt(nr.ft_pincode.getText()) );
            preparedStatement.setString(13,nr.c1.getItemAt(nr.c1.getSelectedIndex())+"");

             
             int row = preparedStatement.executeUpdate();
             
            if (row > 0) {
            	System.out.println(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return -1;
	}
}
