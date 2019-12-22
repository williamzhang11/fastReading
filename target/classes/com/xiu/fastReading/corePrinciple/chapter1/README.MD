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

通过增加服务器的方式可改善负载压力,从而实现系统的可伸缩性.

![image](https://github.com/williamzhang11/fastReading/blob/master/src/main/java/com/xiu/fastReading/corePrinciple/image/1.2.4.jpg)


	通过负载均衡服务器,可将来自用户浏览器的访问请求分发到应用服务器集群中的任何一台服务器,使应用服务器不再成为网站瓶颈.

问题:使用缓存后,绝大部分读操作都可以不通过数据库完成,但仍有一部分读操作,和全部写操作需要访问数据库,当用户达到一部分规模后
,数据库因负载压力过高而造成完整瓶颈

### 1.2.5数据库读写分离

![image](https://github.com/williamzhang11/fastReading/blob/master/src/main/java/com/xiu/fastReading/corePrinciple/image/1.2.5.jpg)

	应用服务器写数据时,访问主数据库,主从数据通过主从复制机制将数据更新同步到从数据库,这样当应用服务器读数据时,
	可以通过从服务器获得数据,为了便于应用程序访问读写分离后的数据,通常使用专门模块,使读写分离对应用透明

问题:用户规模越来越大时,不同地区的网络情况不太一样,速度差别也很大,网站的响应也不一样

### 1.2.6使用反向代理和CDN加速网站响应

![image](https://github.com/williamzhang11/fastReading/blob/master/src/main/java/com/xiu/fastReading/corePrinciple/image/1.2.6.jpg)

	CDN和反向代理原理都是缓存,目的都是尽早返回数据给用户,加快访问速度,减轻后端服务器负载压力.区别是:
	CDN部署在网络提供商机房,用户请求网站服务时,可从距离自己最近的网络提供商机房获取数据
	反向代理部署在网站中心机房.用户请求到达中心机房,首先访问反向代理服务器,如果有则返回给用户.

问题:单一服务无法满足大型网站持续增长的业务需求,数据库经过读写分离后,从一台服务器拆分成2台服务器,依然不能满足需求,这时需要分布式数据库,分布式文件系统.

### 1.2.7分布式文件系统和分布式数据库系统

![image](https://github.com/williamzhang11/fastReading/blob/master/src/main/java/com/xiu/fastReading/corePrinciple/image/1.2.7.jpg)

只有在单表数据规模非常庞大时才使用,更常用的手段是业务分库,将不同业务数据部署在不同物理服务器上

### 1.2.8使用NoSQL和搜索引擎

![image](https://github.com/williamzhang11/fastReading/blob/master/src/main/java/com/xiu/fastReading/corePrinciple/image/1.2.8.jpg)

	随着网站业务越来越复杂,对数据存储和检索需求也越来越复杂,网站需要采用一些非关系型数据库技
	术如NOSQL和非数据库查询技术
	NOSQL和搜索引擎对可伸缩分布式特性具有更好的支持.应用服务器则通过一个统一数据访问模块访
	问各种,减轻应用程序管理诸多数据源的麻烦

### 1.2.9业务拆分

![image](https://github.com/williamzhang11/fastReading/blob/master/src/main/java/com/xiu/fastReading/corePrinciple/image/1.2.9.jpg)

大型网站为了应对日益复杂的业务场景，通过使用分而治之的手段将整个网站业务分为不同的产品线，如大型购物交易网站将首页
商铺，订单，买家，卖家等拆分成不同的产品线，分归为不同业务团队负责。

应用之间通过超链接建立关系（首页上的导航链接每个都指向不同的应用地址），也可通过消息队列进行数据分发。也可通过访问
数据存储系统构成一个关联的完整系统。


问题：随着业务拆分越来越小，存储系统越来越庞大，应用系统的整体复杂度呈指数级增长，部署维护越来越困难，由于所有应用要和所有数据库系统连接，在数万台服务器规模网站中，导致数据库连接资源不足。


### 1.2.10分布式服务

既然每个应用系统都需要指向许多相同的业务操作，如用户管理，商品管理等，可将这些共用业务提取出来，独立部署，由这些可复用的业务连接数据，提供共用业务服务，而应用系统只需要管理用户界面，通过分布式服务调用共有业务服务完成具体业务操作。

![image](https://github.com/williamzhang11/fastReading/blob/master/src/main/java/com/xiu/fastReading/corePrinciple/image/1.2.10.jpg)













