package com.anomalyDetection.Implementation;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.gson.annotations.SerializedName;

@Entity
@Table( name="Purchase" )
public class PurchaseImpl {
	
	 @Id @GeneratedValue
	 @Column(name = "PurchaseEntityId")
	 private Long PurchaseEntityId;

	@SerializedName("event_type")
	  private String Event_type;
	  
	  @SerializedName("timestamp")
	  private String Timestamp;

	  @SerializedName("id")
	  @Column(name="PurchaseId")
	  private int PurchaseId;
	  
	  @SerializedName("amount")
	  private float Amount;
	  
	public Long getPurchaseEntityId() {
		return PurchaseEntityId;
	}

	public void setPurchaseEntityId(Long purchaseEntityId) {
		PurchaseEntityId = purchaseEntityId;
	}

	public String getEvent_type() {
		return Event_type;
	}

	public void setEvent_type(String event_type) {
		this.Event_type = event_type;
	}

	public String getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.Timestamp = timestamp;
	}

	public int getPurchaseId() {
		return PurchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.PurchaseId = purchaseId;
	}

	public float getAmount() {
		return Amount;
	}

	public void setAmount(float amount) {
		this.Amount = amount;
	}
	  
}
