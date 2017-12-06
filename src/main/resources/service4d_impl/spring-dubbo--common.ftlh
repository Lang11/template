<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
	http://code.alibabatech.com/schema/dubbo http://code.alibabatech.com/schema/dubbo/dubbo.xsd">
    
    <dubbo:consumer check="false"/>
    
    <dubbo:application name="com.huadao.channel.${l_channel_name}" owner="huadao-pay-${l_channel_name}-channel" organization="huadao" logger="slf4j"/>
    
    <dubbo:registry protocol="zookeeper" address="${r'${zk.address}'}"/>
    
    <dubbo:protocol name="dubbo" serialization="kryo" port="${r'${service.port}'}" threads="500" threadpool="cached"/>
</beans>