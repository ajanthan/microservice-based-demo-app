#!/bin/bash
echo "Starting project A"
java  -jar eureka-service/target/eureka-service-0.0.1-SNAPSHOT.jar 
java -javaagent:/Users/ajanthan/work/learning/spring-cloud-example/agents/projectA/skywalking-agent.jar -jar projectA/target/projectA-1.0-SNAPSHOT.jar 
java -javaagent:/Users/ajanthan/work/learning/spring-cloud-example/agents/projectA/skywalking-agent.jar -jar projectB/target/projectB-1.0-SNAPSHOT.jar 
java -javaagent:/Users/ajanthan/work/learning/spring-cloud-example/agents/projectA/skywalking-agent.jar -jar projectC/target/projectC-1.0-SNAPSHOT.jar 
echo "Starting project A"
echo "Starting project A"
echo "Starting project A"
