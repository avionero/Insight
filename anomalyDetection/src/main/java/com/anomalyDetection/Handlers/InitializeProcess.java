package com.anomalyDetection.Handlers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import com.anomalyDetection.Domains.ConfigEvent;
import com.anomalyDetection.Implementation.PurchaseImpl;
import com.google.gson.Gson;

import Configurations.AppConfiguration;

public class InitializeProcess {
	
	private String path;
    private File f;
    private File storeF;
    private File storeConfig;
    private AppConfiguration appConfig;
	
	public InitializeProcess(String path){
		int i = 1;
		this.path = path;	
		//TODO check if path is valid
		 File readF = new File(path);
		 storeF = new File("C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_output/purchase_log.json");
		 storeConfig = new File("C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_input/config_data.json");

		 try{
		 LineIterator it = FileUtils.lineIterator(readF, "UTF-8");
			try {
			    while (it.hasNext()) {
			        String line = it.nextLine();
			        if(i==1){
			        	writeConfig(line);			        	
			        }
			        else{
			        	writePurchase(line);
			        }
			        i = i+1;
				}
			} finally {
			    LineIterator.closeQuietly(it);
			   
			}
		 }
		 catch (Exception e)
		 {}
		 	
	}

	public AppConfiguration getAppConfig() {
		return appConfig;
	}
	
	private void writeConfig(String config) 
	{
		BufferedWriter bw = null;
		FileWriter fw = null;
		File ConfigFile = new File("C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_input/config_data.json");
		
		try {
			if (!ConfigFile.exists()) {
				ConfigFile.createNewFile();
			}
			fw = new FileWriter( ConfigFile.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(config);
			System.out.println("Config Append");
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
	
	private void writePurchase(String purchase) 
	{
	    BufferedWriter bw = null;
		FileWriter fw = null;
		File purchaseFile = new File("C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_output/purchase_log.json");
	
		try {
			if (!purchaseFile.exists()) {
				purchaseFile.createNewFile();
			}
			fw = new FileWriter(purchaseFile.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			
			if (String.valueOf(purchase.toCharArray()).contains("\"event_type\":\"purchase\"")){
				bw.write(purchase);
				bw.newLine();
				System.out.println("Line Append");
			}
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
	
