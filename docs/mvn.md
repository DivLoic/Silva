

```{xml}
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.ldivad.ldi</groupId>
    <artifactId>ldi</artifactId>
    <version>0.4.0-SNAPSHOT</version>
    <packaging>pom</packaging>

    <modules>
        <module>ldi-module1</module>
        <module>ldi-module2</module>
        <module>ldi-module3</module>
        <module>ldi-module4</module>
        <module>ldi-module5</module>
    </modules>

    <properties>
        <jdk.version.source>1.7</jdk.version.source>
        <jdk.version.target>1.7</jdk.version.target>
        <junit>4.12</junit>
        <maven-jar-plugin>2.6</maven-jar-plugin>
        <maven-compiler-plugin>3.5.1</maven-compiler-plugin>
        <apache-configuration>1.10</apache-configuration>
        <spark-version>1.5.2</spark-version>
        <kafka-version>0.9.0.1</kafka-version>
        <log4j-version>2.6.1</log4j-version>
        <joda-time>2.9.4</joda-time>
        <hadoop>2.7.1</hadoop>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.scala-lang</groupId>
                <artifactId>scala-library</artifactId>
                <version>${scala.version}</version>
            </dependency>
            <dependency>
                <groupId>org.apache.spark</groupId>
                <artifactId>spark-core_2.10</artifactId>
                <version>${spark-version}</version>
            </dependency>
            <dependency>
                <groupId>org.apache.kafka</groupId>
                <artifactId>kafka-log4j-appender</artifactId>
                <version>${kafka-version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
    
    <build>
        <plugins>
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>${maven-compiler-plugin}</version>
                <configuration>
                    <source>${jdk.version.source}</source>
                    <target>${jdk.version.target}</target>
                </configuration>
            </plugin>
        </plugins>
    </build>

        <profile>
            <id>env-x</id>
            <properties>
                <build.id>env-x</build.id>
                
            </properties>
        </profile>

    </profiles>

</project>
```
