# 第一章-大型网站架构演化

本章主要介绍了大型网站结构演化历史,理解已成功网站架构技术方案的来龙去脉,对技术选型以及架构决策时具有很好的借鉴意义

## 1.1大型网站软件系统的特点

	1.高并发,大流量
	2.高可用
	3.海量数据
	4.用户分布广泛,网络情况复杂
	5.安全环境恶劣
	6.需求快速变更,发布频繁
	7.渐进式发展

## 1.2 大型网站架构演化发展历程

### 1.2.1 初始阶段的网站架构

![image](https://github.com/williamzhang11/fastReading/blob/master/src/main/java/com/xiu/fastReading/corePrinciple/image/1.2.1.jpg)

应用程序,文件,数据库等所有资源都在一台服务器.

问题:越来越多的用户导致性能越来越差,越来越多的数据导致存储中间不足,这时需要将应用和数据分离

### 1.2.2 应用和数据服务器分离

![image](https://github.com/williamzhang11/fastReading/blob/master/src/main/java/com/xiu/fastReading/corePrinciple/image/1.2.2.jpg)


	应用服务器需要处理大量业务逻辑,需要更强大cpu
	数据库服务器需要快速磁盘检索和数据缓存,需要更快的硬盘和更大内存
	文件服务器需要存储大量用户上传文件需要更大硬盘.
	
问题:随着用户增多,数据库压力太大导致访问延迟,进而影响在整个网站性能

### 1.2.3使用缓存改善网站性能

二八定律:80%的业务访问集中20%的数据上.
使用缓存减轻数据库访问压力
![image](https://github.com/williamzhang11/fastReading/blob/master/src/main/java/com/xiu/fastReading/corePrinciple/image/1.2.3.jpg)

	使用的缓存分为:本地缓存,分布式缓存
	本地缓存:本地缓存速度更快,但受限于本地机器内存限制,而且会出现与应用程序争用内存情况
	分布式缓存:可以分布式集群方式部署,部署大内存服务器作为专门缓存服务器,理论上可做到不受内存限制

问题:单一应用服务器能够处理的请求连接有限,在网站访问高峰期,应用服务器成为整个网站瓶颈.

### 1.2.4使用应用服务器集群改善网站并发处理能力





