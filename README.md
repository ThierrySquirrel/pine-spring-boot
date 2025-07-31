# pine-spring-boot-starter

Pine RocketMQ Spring Book Edition

[中文](./README_zh_CN.md)

Support function:

- [x] Service Cluster
- [x] Heartbeat detection
- [x] Get client registration list

# Service Cluster：  
 Cluster strategy adopts synchronous client registration information mode  
 The first pine server that receives client information, automatically synchronizes to other pine servers

# Heartbeat detection：  
 Regularly check whether each service survives  
 If the service does not survive for a long time, it will be rejected.  
   
# Get client registration list 
 Common service cluster solutions  
 Provide client registration information to extend the domain  


## Quick Start

```xml
<!--Adding dependencies to pom. XML-->
        <dependency>
            <artifactId>pine-spring-boot-starter</artifactId>
            <groupId>io.github.thierrysquirrel</groupId>
            <version>1.5.0.0-RELEASE</version>
        </dependency>
``` 

 ### configuration file
 
 ```properties
 ## application.properties
pine.service-url=127.0.0.1:6060 # This is required for service startup
pine.cluster-service-url=127.0.0.1:6060,127.0.0.1:6061,127.0.0.1:6062 # If you need a cluster, please fill in this way
 ```
 
 # Start Pine
 ```java
 @SpringBootApplication
 public class DemoApplication{
     public static void main(String[] args){
         SpringApplication.run(DemoApplication.class, args);
     }
    
 }
 ```
 

 
