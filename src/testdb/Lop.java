package testdb;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;

public class Lop extends Connect{
	String MaLop;
	int NamHoc;
	int HocKy;
	MonHoc monhoc = new MonHoc();
	GiaoVien giaovien = new GiaoVien();
	
	public String getMaLop() {
		return MaLop;
	}
	public void setMaLop(String maLop) {
		MaLop = maLop;
	}
	public int getNamHoc() {
		return NamHoc;
	}
	public void setNamHoc(int namHoc) {
		NamHoc = namHoc;
	}
	public int getHocKy() {
		return HocKy;
	}
	public void setHocKy(int hocKy) {
		HocKy = hocKy;
	}
	public MonHoc getMonhoc() {
		return monhoc;
	}
	public void setMonhoc(MonHoc monhoc) {
		this.monhoc = monhoc;
	}
	public GiaoVien getGiaovien() {
		return giaovien;
	}
	public void setGiaovien(GiaoVien giaovien) {
		this.giaovien = giaovien;
	}
	
	public void ThemLop() {
		GetConnect();
		Scanner scanner = new Scanner(System.in);
		System.out.println("TAO LOP MOI ");
		System.out.print("Nhap Ma Lop : ");
		MaLop = scanner.nextLine();
		
		System.out.print("Nhap Ma Mon Hoc : ");
		String MaMHFromUser = scanner.nextLine();
		monhoc.setMaMH(MaMHFromUser);
		
		System.out.print("Nhap Nam hoc : ");
		NamHoc = scanner.nextInt();
		scanner.nextLine(); // xoa bo nho dem
		
		System.out.print("Nhap Hoc Ky : ");
		HocKy = scanner.nextInt();
		scanner.nextLine(); // xoa bo nho dem
		
		System.out.print("Nhap Ma GV : ");
		String MaGVFromUser = scanner.nextLine();
		giaovien.setMaGV(MaGVFromUser);
		
		try {
			String sql = "INSERT INTO Lop VALUES(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, MaLop);
			ps.setString(2, monhoc.getMaMH());
			ps.setInt(3, NamHoc);
			ps.setInt(4, HocKy);
			ps.setString(5, giaovien.getMaGV());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
	}
	
	public void InLop() {
		GetConnect();
		try {
			String query = "SELECT * FROM Lop";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				MaLop = rs.getString("MaLop");
				String MaMHP = rs.getString("MaMH");
				monhoc.setMaMH(MaMHP);
				NamHoc = rs.getInt("NamHoc");
				HocKy = rs.getInt("HocKy");
				String MaGVP = rs.getString("MaGV");
				giaovien.setMaGV(MaGVP);
				System.out.format("MaLop:%s , MaMH:%s , NamHoc:%d , HocKy:%d , MaGV:%s ",MaLop,monhoc.getMaMH(),
						NamHoc,HocKy,giaovien.getMaGV());
				System.out.println();
			}
		}catch(Exception e) {
		    System.err.println("Got an exception! ");
		    System.err.println(e.getMessage());
		}
		GetClose();	
	}
	
	public void SuaLop() {
		GetConnect();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ID Lop ban muon sua : ");
		String MaLopFromUser = scanner.nextLine();
		
		System.out.print("Nhap Nam Hoc moi : ");
		int NamHocFromUser = scanner.nextInt();
		
		System.out.print("Nhap Hoc Ky moi : ");
		int HocKyFromUser = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Nhap Ma Giao Vien moi : ");
		String MaGVFromUser = scanner.nextLine();
		
		try {
			String sql = "UPDATE Lop SET NamHoc = ? , HocKy = ? , MaGV = ? WHERE MaLop = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, NamHocFromUser);
			ps.setInt(2, HocKyFromUser);
			ps.setString(3, MaGVFromUser);
			ps.setString(4, MaLopFromUser);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
	}
	
	public void HuyLop() {
		GetConnect();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ID Lop ban muon xoa : ");
		String MaLopFromUser = scanner.nextLine();
		
		try {
			String sql = "DELETE FROM Lop WHERE MaLop = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, MaLopFromUser);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
		
	}
}
