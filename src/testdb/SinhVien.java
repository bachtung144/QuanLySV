package testdb;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.sql.Connection;

public class SinhVien extends Connect{
	String MaSV;
	String HoSV;
	String TenSV;
	String NgaySinh;
	String NoiSinh;
	public String getMaSV() {
		return MaSV;
	}
	public void setMaSV(String maSV) {
		MaSV = maSV;
	}
	public String getHoSV() {
		return HoSV;
	}
	public void setHoSV(String hoSV) {
		HoSV = hoSV;
	}
	public String getTenSV() {
		return TenSV;
	}
	public void setTenSV(String tenSV) {
		TenSV = tenSV;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getNoiSinh() {
		return NoiSinh;
	}
	public void setNoiSinh(String noiSinh) {
		NoiSinh = noiSinh;
	}
	
	public void ThemSV() {
		GetConnect();
		Scanner scanner = new Scanner(System.in);
		System.out.println("THEM HO SO SINH VIEN");
		System.out.print("Nhap Ma SV : ");
		MaSV = scanner.nextLine();
		System.out.print("Nhap Ho SV : ");
		HoSV = scanner.nextLine();
		System.out.print("Nhap Ten SV : ");
		TenSV = scanner.nextLine();
		System.out.print("Nhap Ngay Sinh : ");
		NgaySinh = scanner.nextLine();
		System.out.print("Nhap Noi Sinh : ");
		NoiSinh = scanner.nextLine();
		
		
		try {
			String sql = "INSERT INTO SinhVien VALUES(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, MaSV);
			ps.setString(2, HoSV);
			ps.setString(3, TenSV);
			ps.setString(4,NgaySinh);
			ps.setString(5, NoiSinh);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
	}
	
	public void SuaSV() {
		GetConnect();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ID Sinh Vien ban muon sua : ");
		String MaSVFromUser = scanner.nextLine();
		System.out.print("Nhap Ho Sinh Vien moi : ");
		String HoSVFromUser = scanner.nextLine();
		System.out.print("Nhap Ten Sinh Vien moi : ");
		String TenSVFromUser = scanner.nextLine();
		System.out.print("Nhap Ngay Sinh moi : ");
		String NgaySinhFromUser = scanner.nextLine();
		System.out.print("Nhap Noi Sinh moi : ");
		String NoiSinhFromUser = scanner.nextLine();
		
		try {
			String sql = "UPDATE SinhVien SET HoSV = ? , TenSV = ? , NgaySinh = ? , NoiSinh = ? WHERE MaSV = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, HoSVFromUser);
			ps.setString(2, TenSVFromUser);
			ps.setString(3, NgaySinhFromUser);
			ps.setString(4, NoiSinhFromUser);
			ps.setString(5, MaSVFromUser);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
	}

	public void TimSV() {
		GetConnect();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap Ho va Ten Sinh Vien ban muon tim kiem ");
		System.out.print("Nhap Ho : ");
		String HoGVFromUser = scanner.nextLine();
		System.out.print("Nhap Ten : ");
		String TenGVFromUser = scanner.nextLine();
		
		try {
			String sql = "SELECT * FROM SinhVien WHERE HoSV = ? AND TenSV = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, HoGVFromUser);
			ps.setString(2, TenGVFromUser);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			MaSV = rs.getString("MaSV");
			HoSV = rs.getString("HoSV");
			TenSV = rs.getString("TenSV");
			NgaySinh = rs.getString("NgaySinh");
			NoiSinh = rs.getString("NoiSinh");
			System.out.format("MaSV:%s , HoSV:%s , TenSV:%s , NgaySinh:%s , NoiSinh:%s ",MaSV,HoSV,TenSV,NgaySinh,NoiSinh);
			System.out.println();
		}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
	}
}
