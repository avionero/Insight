package com.anomalyDetection.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.anomalyDetection.Implementation.PurchaseImpl;
import com.anomalyDetection.Repository.PurchaseRepository;
import com.google.gson.Gson;

@Service
public class PurchaseService {
	
	@Autowired
	private PurchaseRepository purchaseRepo;
	
	public void StorePurchase(String eventMsg){
		 Gson gson = new Gson();
		 PurchaseImpl purchase = gson.fromJson(eventMsg,PurchaseImpl.class);
	     this.purchaseRepo.save(purchase);
	}

}
