package com.anomalyDetection.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import com.anomalyDetection.Domains.ConfigEvent;
import com.anomalyDetection.Domains.FlaggedPurchase;
import com.google.gson.Gson;


public class PurchasesLog {
	
	
	public List<FlaggedPurchase> LoadAllPurchase(){
		 File configFile = new File("C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_output/purchase_log.json");
		 
		 List<FlaggedPurchase> flagPurchases = new ArrayList<FlaggedPurchase>();
		 FlaggedPurchase flagPurchase;
		 
		 try{
		 LineIterator it = FileUtils.lineIterator(configFile, "UTF-8");
			try {
			    while (it.hasNext()) {
			        String line = it.nextLine();
			       
			        	 Gson gson = new Gson();
			        	 flagPurchase = gson.fromJson(line,FlaggedPurchase.class);
			        	 flagPurchases.add(flagPurchase);
				}
			} finally {
			    LineIterator.closeQuietly(it); 
			}
		 }
		 catch (Exception e)
		 {}
		 return flagPurchases;
	}
	
}
