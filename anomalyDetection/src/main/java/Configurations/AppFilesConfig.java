package Configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="myconfig")
public class AppFilesConfig {
	
	String batchfile; 
	String streamfile; 
	String historyfile; 
	String configfile; 
	String flaggedfile;
	
	public String getBatchfile() {
		return batchfile;
	}
	public void setBatchfile(String batchfile) {
		this.batchfile = batchfile;
	}
	public String getStreamfile() {
		return streamfile;
	}
	public void setStreamfile(String streamfile) {
		this.streamfile = streamfile;
	}
	public String getHistoryfile() {
		return historyfile;
	}
	public void setHistoryfile(String historyfile) {
		this.historyfile = historyfile;
	}
	public String getConfigfile() {
		return configfile;
	}
	public void setConfigfile(String configfile) {
		this.configfile = configfile;
	}
	public String getFlaggedfile() {
		return flaggedfile;
	}
	public void setFlaggedfile(String flaggedfile) {
		this.flaggedfile = flaggedfile;
	} 

}
