package com.anomalyDetection.Handlers;

import com.anomalyDetection.Interfaces.LogEvent;

public class LogEventHndl implements Runnable {
	
	 LogEvent logEvent;
	 String purchase;

	public LogEventHndl(LogEvent _logEvent, String _purchase ) {
		this.logEvent = _logEvent;
	    this.purchase = _purchase;
	}

	@Override
	public void run() {
		 this.logEvent.logEvent(purchase);
		
	}

}
