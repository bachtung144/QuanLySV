package testdb;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;

public class SinhVienLop extends Connect {
	SinhVien sinhvien = new SinhVien();
	Lop lop = new Lop();
	MonHoc monhoc = new MonHoc();
	float Diem;
	
	public SinhVien getSinhvien() {
		return sinhvien;
	}

	public void setSinhvien(SinhVien sinhvien) {
		this.sinhvien = sinhvien;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

	public float getDiem() {
		return Diem;
	}

	public void setDiem(float d) {
		Diem = d;
	}

	public void ThemSVVaoLop() {
		GetConnect();
		Scanner scanner = new Scanner(System.in);
		System.out.println("THEM SINH VIEN VAO LOP ");
		System.out.print("Nhap Ma Sinh Vien Muon Them  : ");
		String MaSVFromUser = scanner.nextLine();
		sinhvien.setMaSV(MaSVFromUser);
		
		System.out.print("Nhap Ma Lop muon them : ");
		String MaLopFromUser = scanner.nextLine();
		lop.setMaLop(MaLopFromUser);
		
		try {
			String sql = "INSERT INTO SinhVienLop (MaSV,MaLop) VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sinhvien.getMaSV());
			ps.setString(2, lop.getMaLop());
			

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
	}
	
	public void DeleteSVKhoiLop() {
		GetConnect();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ID Sinh Vien ban muon xoa khoi lop :");
		String MaSVFromUser = scanner.nextLine();
		sinhvien.setMaSV(MaSVFromUser);
		
		System.out.print("Nhap ID  Lop ma ban muon xoa khoi :");
		String MaLopFromUser = scanner.nextLine();
		lop.setMaLop(MaLopFromUser);
		
		try {
			String sql = "DELETE FROM SinhVienLop WHERE MaSV = ? AND MaLop = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sinhvien.getMaSV());
			ps.setString(2, lop.getMaLop());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GetClose();
	}
	
	public void InDanhSachLopTheoSV() {
		GetConnect();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ID Lop ban muon xem danh sach Sinh Vien ");
		String MaLopFromUser = scanner.nextLine();
		
		try {
			String sql = "SELECT MaLop,SinhVienLop.MaSV As MSVM,HoSV,TenSV"
					+ " FROM SinhVienLop INNER JOIN SinhVien On SinhVienLop.MaSV = SinhVien.MaSV WHERE MaLop = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, MaLopFromUser);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String MaLopP = rs.getString("MaLop");
				lop.setMaLop(MaLopP);
				String MaSVP = rs.getString("MSVM");
				sinhvien.setMaSV(MaSVP);
				String HoSVP = rs.getString("HoSV");
				sinhvien.setHoSV(HoSVP);
				String TenSVP = rs.getString("TenSV");
				sinhvien.setTenSV(TenSVP);
				System.out.format("MaLop:%s , MaSV:%s , HoSV:%s , TenSV:%s   ",
						lop.getMaLop(),sinhvien.getMaSV(),sinhvien.getHoSV(),sinhvien.getTenSV());
				System.out.println();
			}
		}catch(Exception e) {
		    System.err.println("Got an exception! ");
		    System.err.println(e.getMessage());
		}
		GetClose();	
		
	}
	
	public void NhapDiem() {
		GetConnect();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ID Sinh Vien ban muon nhap diem : ");
		String MaSVFromUser = scanner.nextLine();
		System.out.print("Nhap Ma Lop ban muon nhap diem : ");
		String MaLopFromUser = scanner.nextLine();
		System.out.println("Nhap Diem : ");
		Diem = scanner.nextFloat();
		
		try {
			String sql = "UPDATE SinhVienLop SET Diem = ? WHERE MaSV = ? AND MaLop = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setFloat(1, Diem);
			ps.setString(2, MaSVFromUser);
			ps.setString(3, MaLopFromUser);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GetClose();
	}
	
	public void SuaDiem() {
		GetConnect();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ID Sinh Vien ban muon sua diem : ");
		String MaSVFromUser = scanner.nextLine();
		System.out.print("Nhap Ma Lop ban muon sua : ");
		String MaLopFromUser = scanner.nextLine();
		System.out.println("Nhap diem moi : ");
		Diem = scanner.nextFloat();
		
		try {
			String sql = "UPDATE SinhVienLop SET Diem = ? WHERE MaSV = ? AND MaLop = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setFloat(1, Diem);
			ps.setString(2, MaSVFromUser);
			ps.setString(3, MaLopFromUser);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GetClose();
	}
	
	public void InBangDiemChoSV() {
		GetConnect();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap Ma Sinh Vien muon xem diem : ");
		String MaLopFromUser = scanner.nextLine();
		
		try {
			String sql = "select SinhVien.MaSV AS MSV,TenSV,MaLop,MaMH,TenMH,Diem from SinhVien \n" + 
					"inner join\n" + 
					"(select MaSV,MaLop,MonHoc.MaMH,TenMH,Diem from MonHoc\n" + 
					"inner join\n" + 
					"(select  MaSV,A.MaLop,MaMH,Diem from Lop \n" + 
					"inner join \n" + 
					"(select MaSV,MaLop,Diem from SinhVienLop where MaSV = ?) as A\n" + 
					"on Lop.MaLop = A.MaLop) as B\n" + 
					"on MonHoc.MaMH = B.MaMH) as C\n" + 
					"on SinhVien.MaSV = C.MaSV;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, MaLopFromUser);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String MaSVP = rs.getString("MSV");
				sinhvien.setMaSV(MaSVP);
				String TenSVP = rs.getString("TenSV");
				sinhvien.setTenSV(TenSVP);
				String MaLopP = rs.getString("MaLop");
				lop.setMaLop(MaLopP);
				String MaMHP = rs.getString("MaMH");
				monhoc.setMaMH(MaMHP);
				String TenMHP = rs.getString("TenMH");
				monhoc.setTenMH(TenMHP);
				
				Diem = rs.getFloat("Diem");
				System.out.format("MaSV:%s , TenSV:%s , MaLop:%s , MaMH:%s , TenMH:%s , Diem:%f",
						sinhvien.getMaSV(),sinhvien.getTenSV(),lop.getMaLop(),monhoc.getMaMH(),
						monhoc.getTenMH(),Diem);
				System.out.println();
			}
		}catch(Exception e) {
		    System.err.println("Got an exception! ");
		    System.err.println(e.getMessage());
		}
		GetClose();	
	}
	
	public void InBangDiemChoLop() {
		GetConnect();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap Ma lop muon xem diem : ");
		String MaLopFromUser = scanner.nextLine();
		
		try {
			String sql = "SELECT MaLop,SinhVienLop.MaSV As MSVM,HoSV,TenSV,Diem"
			+ " FROM SinhVienLop INNER JOIN SinhVien On SinhVienLop.MaSV = SinhVien.MaSV WHERE MaLop = ? AND Diem IS NOT NULL";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, MaLopFromUser);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String MaLopP = rs.getString("MaLop");
				lop.setMaLop(MaLopP);
				String MaSVP = rs.getString("MSVM");
				sinhvien.setMaSV(MaSVP);
				String HoSVP = rs.getString("HoSV");
				sinhvien.setHoSV(HoSVP);
				String TenSVP = rs.getString("TenSV");
				sinhvien.setTenSV(TenSVP);
				Diem = rs.getFloat("Diem");
				System.out.format("MaLop:%s , MaSV:%s , HoSV:%s , TenSV:%s  ,Diem : %f ",
						lop.getMaLop(),sinhvien.getMaSV(),sinhvien.getHoSV(),sinhvien.getTenSV(),Diem);
				System.out.println();
			}
		}catch(Exception e) {
		    System.err.println("Got an exception! ");
		    System.err.println(e.getMessage());
		}
		GetClose();	
	}
}
