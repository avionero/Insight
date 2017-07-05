package com.anomalyDetection.Domains;

import com.google.gson.annotations.SerializedName;

public class ConfigEvent {
	
	 @SerializedName("D")
	 private int Degree;
	 
	 @SerializedName("T")
	 private int TxnQty;

	public int getDegree() {
		return Degree;
	}

	public void setDegree(int degree) {
		Degree = degree;
	}

	public int getTxnQty() {
		return TxnQty;
	}

	public void setTxnQty(int txnQty) {
		TxnQty = txnQty;
	}

}
