package testdb;

import java.io.IOException;
import java.util.Scanner;

public class QuanTriHeThong {
	Connect con = new Connect();

	public void BackupDB() {
		String executeCmd;
		executeCmd = "mysqldump -u "+con.getUserName()+" -p"+con.getPassword()+" "+con.getDbName()
					+" -r backup.sql";
		try {
			Process	runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();
			if(processComplete == 0) {
				System.out.println("Backup taken successfully.");
			}
			else {
				System.out.println("Could not take mysql backup");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void ResDB() {
		String[] executeCmd;
		executeCmd = new String[]{"/bin/sh", "-c", "mysql -u "+con.getUserName()+" -p"+con.getPassword()+" "+con.getDbName()
					+" < backup.sql"};
		try {
			Process	runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();
			if(processComplete == 0) {
				System.out.println("success.");
			}
			else {
				System.out.println("Restore failure");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
