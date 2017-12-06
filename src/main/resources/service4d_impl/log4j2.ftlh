<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN" monitorInterval="300">  
    <properties>  
        <property name="LOG_HOME">logs</property>  
        <property name="FILE_NAME">channel-${l_channel_name}</property>
    </properties>  
    <Appenders>  
        <Console name="Console" target="SYSTEM_OUT">  
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %l-%msg%n" />  
        </Console>  
        <RollingRandomAccessFile name="MyFile"  
            fileName="${r'${LOG_HOME}'}/${r'${FILE_NAME}'}.log"
            filePattern="${r'${LOG_HOME}'}/${r'$${date:yyyy-MM}'}/${r'${FILE_NAME}'}-%d{yyyy-MM-dd_HH}-%i.log">
            <PatternLayout  
                pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %l-%msg%n" />  
            <Policies>  
                <TimeBasedTriggeringPolicy interval="1" />  
                <SizeBasedTriggeringPolicy size="50 MB" />  
            </Policies>  
            <DefaultRolloverStrategy max="100" />  
        </RollingRandomAccessFile>  
    </Appenders>  
  
    <Loggers>
    	<Logger name="org.springframework" level="warn" />
        <Logger name="com.ielpm" level="debug" >
        	<AppenderRef ref="MyFile" />
        </Logger>
        <Logger name="com.huadao" level="debug">        
            <AppenderRef ref="MyFile" />
        </Logger>
        <Logger name="mylog" level="trace" additivity="false">  
            <AppenderRef ref="MyFile" />  
        </Logger>  
        <Root level="error">  
            <AppenderRef ref="Console" />  
        </Root>  
    </Loggers>  
</Configuration>