package testdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	Connection con;
	String dbName = "testdb";
	String userName = "testuser";
	String password = "123";
	String url = "jdbc:mariadb://localhost:3306/";


	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	public void GetConnect() {
		try{  
			Class.forName("org.mariadb.jdbc.Driver");  
			con=DriverManager.getConnection(url+dbName,userName,password);
		}catch(Exception e){ System.out.println(e);} 
	}
	
	public void GetClose() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

