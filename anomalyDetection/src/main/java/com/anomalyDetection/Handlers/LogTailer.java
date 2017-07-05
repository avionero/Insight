package com.anomalyDetection.Handlers;

import java.io.File;
import org.apache.commons.io.input.Tailer;
import com.anomalyDetection.Adapters.MyTailerListener;


import Configurations.AppConfiguration;

public class LogTailer {
	
	private String path;
	
	 public LogTailer(String path, AppConfiguration  appConfig)
	    {
		 	int degree = 3;
		 	int txn = 50;
		  // "C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_input/stream_log.json"
	        File f = new File(path);
	        MyTailerListener listener = new MyTailerListener();
	        Tailer tailer =  new Tailer(f, listener, 500);
	        try
	        {
	        	while(true)
	        	{
	        		tailer.run();
	        	}
	        	
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
}


