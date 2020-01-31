package testdb;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;

public class ChucNangThem extends Connect{
	public void XoaDB() {
		GetConnect();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM SinhVienLop;");
			PreparedStatement ps1 = con.prepareStatement("DELETE FROM Lop;");
			PreparedStatement ps2 = con.prepareStatement("DELETE FROM SinhVien;");
			PreparedStatement ps3 = con.prepareStatement("DELETE FROM GiaoVien;");
			PreparedStatement ps4 = con.prepareStatement("DELETE FROM MonHoc;");
			ps.execute();
			ps1.execute();
			ps2.execute();
			ps3.execute();
			ps4.execute();
			

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
	}
}
