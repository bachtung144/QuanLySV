package testdb;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;

public class GiaoVien extends Connect {
	String MaGV;
	String HoGV;
	String TenGV;
	String DonVi;
	
	public String getMaGV() {
		return MaGV;
	}
	public void setMaGV(String maGV) {
		MaGV = maGV;
	}
	public String getHoGV() {
		return HoGV;
	}
	public void setHoGV(String hoGV) {
		HoGV = hoGV;
	}
	public String getTenGV() {
		return TenGV;
	}
	public void setTenGV(String tenGV) {
		TenGV = tenGV;
	}
	public String getDonVi() {
		return DonVi;
	}
	public void setDonVi(String donVi) {
		DonVi = donVi;
	}
	
	public void ThemGV() {
		GetConnect();
		Scanner scanner = new Scanner(System.in);
		System.out.println("THEM HO SO GIAO VIEN");
		System.out.print("Nhap Ma GV : ");
		MaGV = scanner.nextLine();
		System.out.print("Nhap Ho GV : ");
		HoGV = scanner.nextLine();
		System.out.print("Nhap Ten GV : ");
		TenGV = scanner.nextLine();
		System.out.print("Nhap Don vi GV : ");
		DonVi = scanner.nextLine();
		
		try {
			String sql = "INSERT INTO GiaoVien VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, MaGV);
			ps.setString(2, HoGV);
			ps.setString(3, TenGV);
			ps.setString(4, DonVi);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
	}
	
	public void InGV() {
		GetConnect();
		try {
			String query = "SELECT * FROM GiaoVien";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				MaGV = rs.getString("MaGV");
				HoGV = rs.getString("HoGV");
				TenGV = rs.getString("TenGV");
				DonVi = rs.getString("DonVi");
				System.out.format("MaGV:%s , HoGV:%s , TenGV:%s , DonVi:%s ",MaGV,HoGV,TenGV,DonVi);
				System.out.println();
			}
		}catch(Exception e) {
		    System.err.println("Got an exception! ");
		    System.err.println(e.getMessage());
		}
		GetClose();		
	}
	
	public void SuaGV() {
		GetConnect();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ID Giao Vien ban muon sua : ");
		String MaGVFromUser = scanner.nextLine();
		System.out.print("Nhap Ho Giao Vien moi : ");
		String HoGVFromUser = scanner.nextLine();
		System.out.print("Nhap Ten Giao Vien moi : ");
		String TenGVFromUser = scanner.nextLine();
		System.out.print("Nhap Don Vi Giao Vien moi : ");
		String DonViFromUser = scanner.nextLine();
		
		try {
			String sql = "UPDATE GiaoVien SET HoGV = ? , TenGV = ? , DonVi = ? WHERE MaGV = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, HoGVFromUser);
			ps.setString(2, TenGVFromUser);
			ps.setString(3, DonViFromUser);
			ps.setString(4, MaGVFromUser);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
	}
	
	public void TimGV() {
		GetConnect();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap Ho va Ten Giao Vien ban muon tim kiem ");
		System.out.print("Nhap Ho : ");
		String HoGVFromUser = scanner.nextLine();
		System.out.print("Nhap Ten : ");
		String TenGVFromUser = scanner.nextLine();
		
		try {
			String sql = "SELECT * FROM GiaoVien WHERE HoGV = ? AND TenGV = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, HoGVFromUser);
			ps.setString(2, TenGVFromUser);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			MaGV = rs.getString("MaGV");
			HoGV = rs.getString("HoGV");
			TenGV = rs.getString("TenGV");
			DonVi = rs.getString("DonVi");
			System.out.format("MaGV:%s , HoGV:%s , TenGV:%s , DonVi:%s ",MaGV,HoGV,TenGV,DonVi);
			System.out.println();
		}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
		
	}
	
}
