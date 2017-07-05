package Configurations;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.stereotype.Component;

import com.anomalyDetection.Domains.ConfigEvent;
import com.anomalyDetection.Implementation.PurchaseImpl;
import com.google.gson.Gson;

@Component
public class AppConfiguration {
	
	private int degree;
	private int txnQty;
	
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public int getTxnQty() {
		return txnQty;
	}
	public void setTxnQty(int txnQty) {
		this.txnQty = txnQty;
	}
	
	public AppConfiguration(){
		loadConfig();
	}
	
	private void loadConfig(){
		 File configFile = new File("C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_input/config_data.json");
		 int i = 1;
		 try{
		 LineIterator it = FileUtils.lineIterator(configFile, "UTF-8");
			try {
			    while (it.hasNext()) {
			        String line = it.nextLine();
			        if(i==1){
			        	 Gson gson = new Gson();
			        	 ConfigEvent config = gson.fromJson(line,ConfigEvent.class);
			    	     this.degree = config.getDegree();
			    	     this.txnQty = config.getTxnQty();
			        }
			        break;
				}
			} finally {
			    LineIterator.closeQuietly(it); 
			}
		 }
		 catch (Exception e)
		 {}
	}
	
	

}
