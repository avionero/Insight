package com.anomalyDetection.Util;

import com.anomalyDetection.Domains.FlaggedPurchase;
import com.google.gson.Gson;

public class ParserFactory {
	
	public FlaggedPurchase ParserPurchase(String purchase){
   	 Gson gson = new Gson();
   	 FlaggedPurchase flagPurchase = gson.fromJson(purchase,FlaggedPurchase.class);
		
   	 return flagPurchase;
	}
	
	public String FlaggedPurchaseToJSON(FlaggedPurchase purchase){
	   	 Gson gson = new Gson();
	   	 String flagPurchaseJSON = gson.toJson(purchase,FlaggedPurchase.class);
			
	   	 return flagPurchaseJSON;
		}

}
