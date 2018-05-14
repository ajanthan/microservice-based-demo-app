#!/usr/bin/env bash

productms=../tracing-demo-product-ms/target/tracing-demo-product-ms-0.0.1-SNAPSHOT.jar
productmsPID=productms.pid

imagems=../tracing-demo-image-ms/target/tracing-demo-image-ms-0.0.1-SNAPSHOT.jar
imagemsPID=imagems.pid

orderms=../tracing-demo-order-ms/target/tracing-demo-order-ms-0.0.1-SNAPSHOT.jar
ordermsPID=orderms.pid

eureka=../tracing-demo-service-discovery/target/tracing-demo-service-discovery-0.0.1-SNAPSHOT.jar
eurekaPID=eureka.pid

gateway=../tracing-demo-gateway/target/tracing-demo-gateway-0.0.1-SNAPSHOT.jar
gatewayPID=gateway.pid

webui=../tracing-demo-ui/target/tracing-demo-ui-0.0.1-SNAPSHOT.jar
webuiPID=webui.pid

agent_location=$PWD/agents
log_location=$PWD/logs