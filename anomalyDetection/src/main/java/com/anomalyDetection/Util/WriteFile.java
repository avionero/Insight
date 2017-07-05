package com.anomalyDetection.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	
	public void FileLineAppend(String line, String path) 
	{
	    BufferedWriter bw = null;
		FileWriter fw = null;
		File file = new File(path);
	
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			
			bw.write(line);
			bw.newLine();

		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (bw != null)
					bw.close();
				
				if (fw != null)
					fw.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
