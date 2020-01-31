package testdb;

import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		MonHoc monhoc = new MonHoc();
		GiaoVien giaovien = new GiaoVien();
		SinhVien sinhvien = new SinhVien();
		Lop lop = new Lop();
		SinhVienLop sinhvienlop = new SinhVienLop();
		QuanTriHeThong quantrihethong = new QuanTriHeThong();
		ChucNangThem chucnangthem = new ChucNangThem();
		ReadFile readfile = new ReadFile();
		while(true) {
			menuChucNang();
			Scanner scanner = new Scanner(System.in);
			System.out.print("Nhap chuc nang  ban muon : ");
			int Choose = scanner.nextInt();
			scanner.nextLine();
			
			switch(Choose) {
			
			case 1:
					while(true) {
						menuMH();
						System.out.print("Nhap chuc nang  ban muon : ");
						int ChooseP = scanner.nextInt();
						scanner.nextLine();
						
						switch(ChooseP) {
						case 1 : 
			         		System.out.println("1.Them Mon Hoc bang ta");
			         		System.out.println("2.Them Mon Hoc bang file");
			         		System.out.print("Nhap chuc nang  ban muon : ");
			         		int ChoosePP = scanner.nextInt();
			         		scanner.nextLine();
			         		if(ChoosePP == 1) monhoc.ThemMH();
			         		if(ChoosePP == 2) readfile.DocFileMH();
							break;
								
						case 2 : monhoc.SuaMH();
								break;
						case 3 : monhoc.InMH();
								break;
						}	
						if (ChooseP == 4) break; 
					}	
					break;
			
			case 2: 
					while(true) {
					menuGV();
					System.out.print("Nhap chuc nang  ban muon : ");
					int ChooseP = scanner.nextInt();
					scanner.nextLine();
					
					switch(ChooseP) {
					case 1 : 
			         		System.out.println("1.Them giao vien bang tay");
			         		System.out.println("2.Them giao vien bang file");
			         		System.out.print("Nhap chuc nang  ban muon : ");
			         		int ChoosePP = scanner.nextInt();
			         		scanner.nextLine();
			         		if(ChoosePP == 1) giaovien.ThemGV();
			         		if(ChoosePP == 2) readfile.DocFileGV();
							break;
					case 2 : giaovien.SuaGV();
							break;
					case 3 : giaovien.InGV();
							break;
					case 4 : giaovien.TimGV();
							break;
					}	
					if (ChooseP == 5) break; 
					}	
					break;
			case 3 :
					while(true) {
						menuSV();
						System.out.print("Nhap chuc nang  ban muon : ");
						int ChooseP = scanner.nextInt();
						scanner.nextLine();
				
						switch(ChooseP) {
						case 1 : 
			         		System.out.println("1.Them sinh vien bang tay");
			         		System.out.println("2.Them sinh vien bang file");
			         		System.out.print("Nhap chuc nang  ban muon : ");
			         		int ChoosePP = scanner.nextInt();
			         		scanner.nextLine();
			         		if(ChoosePP == 1) sinhvien.ThemSV();
			         		if(ChoosePP == 2) readfile.DocFileSV();
						break;
						case 2 : sinhvien.SuaSV();
						break;
						case 3 : sinhvien.TimSV();
						break;
						}	
						if (ChooseP == 4) break; 
						}	
					break;
			 case 4: 
					while(true) {
						menuLop();
						System.out.print("Nhap chuc nang  ban muon : ");
						int ChooseP = scanner.nextInt();
						scanner.nextLine();
				
						switch(ChooseP) {
						case 1 : 
			         		System.out.println("1.Them lop bang tay");
			         		System.out.println("2.Them lop bang file");
			         		System.out.print("Nhap chuc nang  ban muon : ");
			         		int ChoosePP = scanner.nextInt();
			         		scanner.nextLine();
			         		if(ChoosePP == 1) lop.ThemLop();
			         		if(ChoosePP == 2) readfile.DocFileLop();
						break;
						case 2 : lop.SuaLop();
						break;
						case 3 : sinhvienlop.ThemSVVaoLop();
						break;
						case 4 : sinhvienlop.DeleteSVKhoiLop();
						break;
						case 5 : lop.HuyLop();
						break;
						case 6 : System.out.println("1.In danh sach tat ca cac lop ");
						         System.out.println("2.In danh sach sinh vien theo ma lop ");
								 System.out.print("Nhap chuc nang  ban muon : ");
								 int ChoosePPP = scanner.nextInt();
								 scanner.nextLine();
								 if(ChoosePPP == 1) lop.InLop();
								 if(ChoosePPP == 2) sinhvienlop.InDanhSachLopTheoSV();
						break;
						}	
						if (ChooseP == 7) break; 
						}	
					break;
			case 5:
				   while(true) {
					   menuDiem();
					   System.out.print("Nhap chuc nang  ban muon : ");
					   int ChooseP = scanner.nextInt();
					   scanner.nextLine();
			
					   switch(ChooseP) {
					   case 1 : 
			         		System.out.println("1.Them diem bang tay");
			         		System.out.println("2.Them diem bang file");
			         		System.out.print("Nhap chuc nang  ban muon : ");
			         		int ChoosePP = scanner.nextInt();
			         		scanner.nextLine();
			         		if(ChoosePP == 1) sinhvienlop.NhapDiem();
			         		if(ChoosePP == 2) readfile.DocFileSVL();
					   break;
					   case 2 : sinhvienlop.SuaDiem();
					   break;
					   case 3 : sinhvienlop.InBangDiemChoLop();
					   break;
					   case 4 : sinhvienlop.InBangDiemChoSV();
					   break;
					   }	
					   if (ChooseP == 5) break; 
						}	
				   break;
			case 6:
				   while(true) {
					   menuQTHT();
					   System.out.print("Nhap chuc nang  ban muon : ");
					   int ChooseP = scanner.nextInt();
					   scanner.nextLine();
			
					   switch(ChooseP) {
					   case 1 : quantrihethong.BackupDB();
					   break;
					   case 2 : quantrihethong.ResDB();
					   break;
					   }	
					   if (ChooseP == 3) break; 
						}	
				   break;
			case 7: chucnangthem.XoaDB();
					break;
			case 8:System.exit(0);
			}
		}
	}

	public static void menuChucNang() {
		System.out.println();
		System.out.println("=========CHUONG TRINH QUAN LY=========");
		System.out.println("1.Quan ly mon hoc ");
		System.out.println("2.Quan ly giao vien  ");
		System.out.println("3.Quan ly sinh vien ");
		System.out.println("4.Quan ly lop");
		System.out.println("5.Quan ly diem");
		System.out.println("6.Quan ly he thong");
		System.out.println("7.Xoa DataBase");
		System.out.println("8.Thoat");
		System.out.println();
		
	}
	
	public static void menuMH() {
		System.out.println();
		System.out.println("==========QUAN LY MON HOC============");
		System.out.println("1.Them mon hoc moi ");
		System.out.println("2.Sua thong tin mon hoc ");
		System.out.println("3.In danh sach mon hoc ");
		System.out.println("4.Thoat");
		System.out.println();
	}
	
	public static void menuGV() {
		System.out.println();
		System.out.println("==========QUAN LY GIAO VIEN==========");
		System.out.println("1.Them ho so Giao Vien ");
		System.out.println("2.Sua thong tin Giao Vien ");
		System.out.println("3.In danh sach Giao Vien ");
		System.out.println("4.Tim kiem Giao Vien");
		System.out.println("5.Thoat");
		System.out.println();
	}
	
	public static void menuSV() {
		System.out.println();
		System.out.println("===========QUAN LY SINH VIEN==========");
		System.out.println("1.Them ho so Sinh Vien ");
		System.out.println("2.Sua thong tin Sinh Vien ");
		System.out.println("3.Tim kiem Sinh Vien");
		System.out.println("4.Thoat");
		System.out.println();
	}
	
	public static void menuLop() {
		System.out.println();
		System.out.println("===========QUAN LY LOP==============");
		System.out.println("1.Tao lop moi ");
		System.out.println("2.Sua doi thong tin lop  ");
		System.out.println("3.Bo sung sinh vien vao lop ");
		System.out.println("4.Loai bo sinh vien khoi lop");
		System.out.println("5.Huy lop ");
		System.out.println("6.In danh sach lop ");
		System.out.println("7.Thoat");
		System.out.println();
	}
	public static void menuDiem() {
		System.out.println();
		System.out.println("============QUAN LY DIEM=============");
		System.out.println("1.Nhap Diem ");
		System.out.println("2.Sua Diem ");
		System.out.println("3.In bang diem cho lop ");
		System.out.println("4.In bang diem cho sinh vien ");
		System.out.println("1.Thoat ");
	}
	public static void menuQTHT() {
		System.out.println();
		System.out.println("============QUAN TRI HE THONG==========");
		System.out.println("1.BackUp DataBase");
		System.out.println("2.Restore DataBase");
		System.out.println("3.Thoat");
		System.out.println();
	}
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
}
