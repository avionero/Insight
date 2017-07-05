package com.anomalyDetection.Interfaces;

import com.google.gson.annotations.SerializedName;

public interface Purchase {

		public String getEvent_type();
		public void setEvent_type(String event_type);
		public String getTimestamp() ;
		public void setTimestamp(String timestamp);
		public int getId();
		public void setId(int id);
		public float getAmount();
		public void setAmount(float amount);
		  
	}
