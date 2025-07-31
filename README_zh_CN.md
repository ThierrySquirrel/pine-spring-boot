# pine-spring-boot-starter

松树RocketMQ   SpringBoot 版

[English](./README.md)

支持功能：
- [x] 服务集群
- [x] 心跳检测
- [x] 获取客户端注册列表

# 服务集群：  
 集群策略采用同步客户端注册信息模式  
 第一个收到客户端信息的松树服务器，自动同步到其他松树服务器

# 心跳检测：  
 定时检测每个服务是否存活  
 服务长时间未存活会被剔除  
 
# 获取客户端注册列表  
 常见的服务集群方案  
 提供客户端注册信息达到延伸领域作用  
 
## Quick Start

```xml
<!--在pom.xml中添加依赖-->
        <dependency>
            <artifactId>pine-spring-boot-starter</artifactId>
            <groupId>io.github.thierrysquirrel</groupId>
            <version>1.5.0.0-RELEASE</version>
        </dependency>
``` 

 ### 配置文件
 
 ```properties
 ## application.properties
pine.service-url=127.0.0.1:6060 # 这是必须填写的，用于服务启动
pine.cluster-service-url=127.0.0.1:6060,127.0.0.1:6061,127.0.0.1:6062 # 如果您需要集群，请这样填写
 ```
 
 # 启动Pine
 ```java
 @SpringBootApplication
 public class DemoApplication{
     public static void main(String[] args){
         SpringApplication.run(DemoApplication.class, args);
     }
    
 }
 ```
 
