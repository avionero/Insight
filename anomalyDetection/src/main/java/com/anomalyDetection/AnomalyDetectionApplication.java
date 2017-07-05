package com.anomalyDetection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import com.anomalyDetection.Handlers.InitializeProcess;
import com.anomalyDetection.Handlers.LogTailer;

@SpringBootApplication
public class AnomalyDetectionApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AnomalyDetectionApplication.class, args);
		InitializeProcess intProc = new InitializeProcess("C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_input/batch_log.json");
		
		new LogTailer( "C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_input/stream_log.json", intProc.getAppConfig());
	}
}
