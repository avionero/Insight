package com.anomalyDetection.Implementation;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.anomalyDetection.Domains.FlaggedPurchase;
import com.anomalyDetection.Interfaces.LogEvent;
import com.anomalyDetection.Util.ParserFactory;
import com.anomalyDetection.Util.PurchasesLog;
import com.anomalyDetection.Util.Statistics;
import com.anomalyDetection.Util.WriteFile;

import Configurations.AppConfiguration;

public class LogEventImpl  implements LogEvent {

	FlaggedPurchase flagPurchase;
	double amounts[];
	double  mean;
	double  sd;
	int cntr = 0;
	
	public void logEvent(String purchase) {
		// TODO Auto-generated method stub
		
		if(purchase != null)
		{
			AppConfiguration appConfig = new AppConfiguration();
			FlaggedPurchase curFlagPurchase = new ParserFactory().ParserPurchase(purchase);
			List<FlaggedPurchase> purchases = new PurchasesLog().LoadAllPurchase();
			
			List<FlaggedPurchase> filterPurchases = new ArrayList<FlaggedPurchase>();
			
			amounts = new double[purchases.size()];
			for (FlaggedPurchase flagPurchase : purchases) {
				if (flagPurchase.getId() != curFlagPurchase.getId() ){
					filterPurchases.add(flagPurchase);
					amounts[cntr] = flagPurchase.getAmount(); 
				}
				cntr+=1;
			}
			
			Statistics stats = new Statistics(amounts);
			mean = stats.getMean();
			sd = stats.getStdDev();
			double anomallyVal = stats.xMeanDeviation(3, mean, sd);
				
			if (curFlagPurchase.getAmount() > anomallyVal)
			{
				curFlagPurchase.setMean( stats.RoundTo2Decimals(mean));
				curFlagPurchase.setSd( stats.RoundTo2Decimals(sd));
				
				String flaggedPurchaseJson = new ParserFactory().FlaggedPurchaseToJSON(curFlagPurchase);
				
				new WriteFile().FileLineAppend(flaggedPurchaseJson,"C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_output/flagged_purchases.json");
				
				System.out.println("Abnormal Purchase");
			}
			else 
				System.out.println("Normal Purchase");
		}
	}

}
