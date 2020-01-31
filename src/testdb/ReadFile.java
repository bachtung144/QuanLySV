package testdb;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.sql.Connection;

public class ReadFile extends Connect{
	MonHoc mh = new MonHoc();
	GiaoVien gv = new GiaoVien();
	SinhVien sv = new SinhVien();
	Lop l = new Lop();
	SinhVienLop svl = new SinhVienLop();
	
	public void DocFileMH() {
		GetConnect();
		String csvFilePath = "./DB1/MonHoc.csv";
		String sqlInsert = "INSERT INTO MonHoc "
                + " VALUE(?,?,?);";
		try {
			
        PreparedStatement ps = con.prepareStatement(sqlInsert);
        BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
        String lineText = null;

        while ((lineText = lineReader.readLine()) != null) {
            String[] data = lineText.split(",");
            mh.setMaMH(data[0]);
            mh.setTenMH(data[1]);
            mh.setSoTC(Integer.parseInt(data[2]));
            ps.setString(1, mh.getMaMH());
            ps.setString(2, mh.getTenMH());
            ps.setInt(3, mh.getSoTC());
            ps.execute();
        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		System.out.println("Da Them");
		GetClose();
	}
	
	public void DocFileGV() {
		GetConnect();
		String csvFilePath = "./DB1/GiaoVien.csv";
		String sqlInsert = "INSERT INTO GiaoVien VALUES(?,?,?,?) ";
                
		try {
			
        PreparedStatement ps = con.prepareStatement(sqlInsert);
        BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
        String lineText = null;

        while ((lineText = lineReader.readLine()) != null) {
            String[] data = lineText.split(",");
            gv.setMaGV(data[0]);
            gv.setHoGV(data[1]);
            gv.setTenGV(data[2]);
            gv.setDonVi(data[3]);
            ps.setString(1, gv.getMaGV());
            ps.setString(2, gv.getHoGV());
            ps.setString(3, gv.getTenGV());
            ps.setString(4, gv.getDonVi());
            
            ps.execute();
        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		System.out.println("Da Them");
		GetClose();
	}
	
	public void DocFileSV() {
		GetConnect();
		String csvFilePath = "./DB1/SinhVien.csv";
		String sqlInsert = "INSERT INTO SinhVien VALUES(?,?,?,?,?) ";
                
		try {
			
        PreparedStatement ps = con.prepareStatement(sqlInsert);
        BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
        String lineText = null;

        while ((lineText = lineReader.readLine()) != null) {
            String[] data = lineText.split(",");
            sv.setMaSV(data[0]);
            sv.setHoSV(data[1]);
            sv.setTenSV(data[2]);
            sv.setNgaySinh(data[3]);
            sv.setNoiSinh(data[4]);
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getHoSV());
            ps.setString(3, sv.getTenSV());
            ps.setString(4, sv.getNgaySinh());
            ps.setString(5, sv.getNoiSinh());
            
            ps.execute();
        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		System.out.println("Da Them");
		GetClose();
	}
	
	public void DocFileLop() {
		GetConnect();
		String csvFilePath = "./DB1/Lop.csv";
		String sqlInsert = "INSERT INTO Lop VALUES(?,?,?,?,?) ";
                
		try {
			
        PreparedStatement ps = con.prepareStatement(sqlInsert);
        BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
        String lineText = null;

        while ((lineText = lineReader.readLine()) != null) {
          String[] data = lineText.split(",");           
          l.setMaLop(data[0]);
          mh.setMaMH(data[1]);
          l.setNamHoc(Integer.parseInt(data[2]));
          l.setHocKy(Integer.parseInt(data[3]));
          gv.setMaGV(data[4]);
          ps.setString(1, l.getMaLop());
          ps.setString(2, mh.getMaMH());
          ps.setInt(3, l.getNamHoc());
          ps.setInt(4, l.getHocKy());
          ps.setString(5, gv.getMaGV());
          ps.execute();
        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		System.out.println("Da Them");
		GetClose();
	}
	
	public void DocFileSVL() {
		GetConnect();
		String csvFilePath = "./DB1/SinhVienLop.csv";
		String sqlInsert = "INSERT INTO SinhVienLop VALUES(?,?,?) ";
                
		try {
			
        PreparedStatement ps = con.prepareStatement(sqlInsert);
        BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
        String lineText = null;

        while ((lineText = lineReader.readLine()) != null) {
          String[] data = lineText.split(",");           
          sv.setMaSV(data[0]);
          l.setMaLop(data[1]);
          svl.setDiem(Float.parseFloat(data[2]));
          ps.setString(1, l.getMaLop());
          ps.setString(2, sv.getMaSV());
          ps.setFloat(3, svl.getDiem());
          ps.execute();
        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		System.out.println("Da Them");
		GetClose();
	}
		
}	
