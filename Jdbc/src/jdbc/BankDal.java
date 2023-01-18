package jdbc;
import static jdbc.Connect.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BankDal {
	public static Connection con;
	static {
		try {
			openConnection();
			con=getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Account> getAccount() throws SQLException{
		List<Account> li=new ArrayList<Account>();
		String query="select * from accounts";
		ResultSet rset=con.createStatement().executeQuery(query);
		while(rset.next()) {
			
			li.add(new Account(rset.getInt(1),rset.getString(2),rset.getString(3), rset.getDouble(4)));
		}
		return li;
	}
	
	public void insertAccount(Account acc) throws SQLException {
		String query="insert into accounts(name,type,bal) values(?,?,?)";
		 CallableStatement stm=con.prepareCall(query);
		 stm.setString(1,acc.getName());
		 stm.setString(2,acc.getType());
		 stm.setDouble(3, acc.getBalance());
		 stm.executeUpdate();
	}
	public void updateAccount(Account acc) throws SQLException {
		String query="update accouts set name=?,type=?,bal=?";
		 CallableStatement stm=con.prepareCall(query);
		 stm.setString(1,acc.getName());
		 stm.setString(2,acc.getType());
		 stm.setDouble(3, acc.getBalance());
		 stm.executeUpdate();
	}
	public void deleteAccount(int id) throws SQLException {
		String query="delete from accounts where id=?";
		 CallableStatement stm=con.prepareCall(query);
		 stm.setInt(1,id);
		 stm.executeUpdate();
	}
	
	public void depositAccount(int id,double ammount) throws SQLException {
		String query="select bal from accounts where id=?";
		 CallableStatement stm=con.prepareCall(query);
		 stm.setInt(1,id);
		 ResultSet rset=stm.executeQuery();
		if(rset.next()) {
			Double temp= rset.getDouble(1)+ammount;
			query="update accounts set bal=? where id=?";
			 CallableStatement stm1=con.prepareCall(query);
			 stm1.setDouble(1,temp);
			 stm1.setInt(2, id);
			 stm1.executeUpdate();
		}else {
			System.out.println("Not exist");
		}
		
	}
	
	public void withdrawAccount(int id,double ammount) throws SQLException {
		String query="select bal from accounts where id=?";
		 CallableStatement stm=con.prepareCall(query);
		 stm.setInt(1,id);
		 ResultSet rset=stm.executeQuery();
		if(rset.next()) {
			Double temp= rset.getDouble(1)-ammount;
			query="update accounts set bal=? where id=?";
			 CallableStatement stm1=con.prepareCall(query);
			 stm1.setDouble(1,temp);
			 stm1.setInt(2, id);
			 stm1.executeUpdate();
		}else {
			System.out.println("Not exist");
		}
		
	}
	
	
}
