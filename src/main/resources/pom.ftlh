<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.huadao</groupId>
    <artifactId>${l_channel_name}-channel</artifactId>
    <packaging>pom</packaging>
    <version>1.0.0-SNAPSHOT</version>
    <modules>
        <module>${l_channel_name}-channel-interface</module>
        <module>${l_channel_name}-channel-service</module>
    </modules>
    <name>${l_channel_name}-channel</name>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
        <spring.version>4.2.4.RELEASE</spring.version>
    </properties>
    <!-- 私有库地址 -->
    <repositories>
        <repository>
            <id>nexus</id>
            <url>http://192.168.35.233:8081/nexus/content/groups/public/</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
        <repository>
            <id>freeib</id>
            <url>http://192.168.35.233:8081/nexus/content/repositories/freeib/</url>
        </repository>
        <repository>
            <id>freeib-snapshot</id>
            <url>http://192.168.35.233:8081/nexus/content/repositories/freeib-snapshot/</url>
        </repository>
    </repositories>
    <!--私有插件库地址 -->
    <pluginRepositories>
        <pluginRepository>
            <id>nexus</id>
            <url>http://192.168.35.233:8081/nexus/content/groups/public/</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </pluginRepository>
    </pluginRepositories>
    <!-- 发布配置 -->
    <distributionManagement>
        <repository>
            <id>releases</id>
            <name>User Project Release</name>
            <url>http://192.168.35.233:8081/nexus/content/repositories/freeib/</url>
        </repository>
        <snapshotRepository>
            <id>snapshots</id>
            <name>User Project SNAPSHOTS</name>
            <url>http://192.168.35.233:8081/nexus/content/repositories/freeib-snapshot/</url>
        </snapshotRepository>
    </distributionManagement>
    <!-- 所有模块的依赖 -->
    <dependencyManagement>
        <dependencies>
        </dependencies>
    </dependencyManagement>
    <dependencies>

    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.5.1</version>
                <configuration>
                    <encoding>${r'${project.build.sourceEncoding}'}</encoding>
                    <source>${r'${maven.compiler.source}'}</source>
                    <target>${r'${maven.compiler.target}'}</target>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-archetype-plugin</artifactId>
                <version>2.2</version>
            </plugin>
        </plugins>
    </build>
    <reporting>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-pmd-plugin</artifactId>
                <version>3.7</version>
            </plugin>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>findbugs-maven-plugin</artifactId>
                <version>3.0.0</version>
            </plugin>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>cobertura-maven-plugin</artifactId>
                <version>2.7</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-checkstyle-plugin</artifactId>
                <version>2.17</version>
                <configuration>
                    <configLocation>google_checks.xml</configLocation>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
        </plugins>
    </reporting>
</project>