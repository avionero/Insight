package com.anomalyDetection.Domains;
import com.google.gson.annotations.SerializedName;

public class FlaggedPurchase {

	  @SerializedName("event_type")
	  private String event_type;

	  @SerializedName("timestamp")
	  private String timestamp;

	  @SerializedName("id")
	  private int id;
	  
	  @SerializedName("amount")
	  private float amount;
	  
	  @SerializedName("mean")
	  private double mean;
	  
	  @SerializedName("sd")
	  private double sd;

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public double getMean() {
		return mean;
	}

	public void setMean(double mean) {
		this.mean = mean;
	}

	public double getSd() {
		return sd;
	}

	public void setSd(double sd) {
		this.sd = sd;
	}
}
