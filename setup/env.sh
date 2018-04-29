#!/usr/bin/env bash


dataservice=../tracing-demo-data/target/tracing-demo-data-0.0.1-SNAPSHOT.jar
dataservicePID=dataservice.pid

bussinessservice=../tracing-demo-service/target/tracing-demo-service-0.0.1-SNAPSHOT.jar
bussinessservicePID=bussinessservice.pid

gateway=../tracing-demo-gateway/target/tracing-demo-gateway-0.0.1-SNAPSHOT.jar
gatewayPID=gateway.pid

webui=../tracing-demo-ui/target/tracing-demo-ui-0.0.1-SNAPSHOT.jar
webuiPID=webui.pid

agent_location=$PWD/agents
log_location=$PWD/logs