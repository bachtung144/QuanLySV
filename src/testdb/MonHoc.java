package testdb;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;


public class MonHoc extends Connect{
	String MaMH;
	String TenMH;
	int SoTC;
	
	public String getMaMH() {
		return MaMH;
	}

	public void setMaMH(String maMH) {
		MaMH = maMH;
	}

	public String getTenMH() {
		return TenMH;
	}

	public void setTenMH(String tenMH) {
		TenMH = tenMH;
	}

	public int getSoTC() {
		return SoTC;
	}

	public void setSoTC(int soTC) {
		SoTC = soTC;
	}
	
	public void ThemMH () {
		GetConnect();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nhap them mon hoc moi : ");
		
		System.out.println("Nhap ma mon hoc : ");
		MaMH = scan.nextLine();
		
		System.out.println("Nhap ten mon hoc : ");
		TenMH = scan.nextLine();
		
		System.out.println("Nhap so tin chi : ");
		SoTC = scan.nextInt();
		
		try {
			String sql = "INSERT INTO MonHoc VALUES(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, MaMH);
			ps.setString(2, TenMH);
			ps.setInt(3, SoTC);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
	}
	
	public void InMH() {

		GetConnect();
		try {
			String query = "SELECT * FROM MonHoc";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				MaMH = rs.getString("MaMH");
				TenMH = rs.getString("TenMH");
				SoTC = rs.getInt("SoTC");
				System.out.format("MaMH:%s , TenMH:%s , SoTC:%s",MaMH,TenMH,SoTC);
				System.out.println();
			}
		}catch(Exception e) {
		    System.err.println("Got an exception! ");
		    System.err.println(e.getMessage());
		}
		GetClose();
	}
	
	public void SuaMH() {
		GetConnect();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ID mon hoc ban muon sua : ");
		String MaMHFromUser = scanner.nextLine();
		System.out.print("Nhap ten mon hoc moi : ");
		String TenMHFromUser = scanner.nextLine();
		System.out.print("Nhap so tin chi moi : ");
		int SoTCFromUser = scanner.nextInt();
		
		try {
			String sql = "UPDATE MonHoc SET TenMH = ? , SoTC = ? WHERE MaMH = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, TenMHFromUser);
			ps.setInt(2, SoTCFromUser);
			ps.setString(3, MaMHFromUser);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
		
	}
}






