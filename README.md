# Table of Contents
1. [Summary](README.md#challenge-summary)
2. [Configuration](README.md#details-of-implementation)
3. [Architecture](README.md#anomalous-purchases)
4. [Sample Data](README.md#sample-data)



# Summary
This is the code develope fo the Insight challenge were was to build a real-time platform to analyze purchases within a 
social network of users, and detect any behavior that is far from the average within that social network. 

In overall the solution deliver do the job but for me is not finish yet and probably not meet your standards. Even though i want to
deliver it anyway to give the thank for the oportunity. Even said that if you decide to run the program you have to configure the path to 
your local enviroment.

# Configuration

Path of the diferent files handle by the application are define hardcoded in the application. Causse for some how I could make the 
application to read them from the configuration files.

  ### batchfile: C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_input/batch_log.json
  ### streamfile: C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_input/stream_log.json
  ### historyfile: C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_output/purchase_log.json
  ### configfile: C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_input/config_data.json
  ### flaggedfile: C:/Users/elix/workspace/anomalyDetection/src/main/resources/log_output/flagged_purchases.json

