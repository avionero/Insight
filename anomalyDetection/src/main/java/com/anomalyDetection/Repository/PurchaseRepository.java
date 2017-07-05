package com.anomalyDetection.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anomalyDetection.Implementation.PurchaseImpl;

@Repository
public interface PurchaseRepository extends CrudRepository<PurchaseImpl, Long>{
	
}