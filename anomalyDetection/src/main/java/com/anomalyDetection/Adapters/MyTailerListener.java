package com.anomalyDetection.Adapters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.input.TailerListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anomalyDetection.Handlers.LogEventHndl;
import com.anomalyDetection.Implementation.LogEventImpl;
import com.anomalyDetection.Implementation.PurchaseImpl;
import com.anomalyDetection.Repository.PurchaseRepository;
import com.anomalyDetection.Services.PurchaseService;
import com.google.gson.Gson;

public class MyTailerListener extends TailerListenerAdapter
{	
	//Log event handler - This method make different call based on the event_type registered
    @Override
    public void handle(String eventMsg)
    {
    	try{
        	writePurchase(eventMsg);
    	}
    	catch(Exception e)
    	{
    		
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
	  	        LogEventImpl callBack = new LogEventImpl();
	  	        LogEventHndl caller = new LogEventHndl(callBack, purchase);
	  	        caller.run();
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
