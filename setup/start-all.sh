#!/bin/bash
source env.sh
#echo "Starting project ES"
#nohup bash es/elasticsearch-5.5.0/bin/elasticsearch 2>> /dev/null >> /dev/null &
#echo $! > es.pid
#
#echo "Starting apm collector"
#bash apm/apache-skywalking-apm-incubating/bin/collectorService.sh
#echo $! > collector.pid
#
#echo "Starting apm ui"
#bash apm/apache-skywalking-apm-incubating/bin/webappService.sh
#echo $! > apm-ui.pid

echo "Agent location is $agent_location"

echo "Starting product ms"
product_log=$log_location/product-ms.log

if [ ! -f $product_log ]; then
    mkdir -p $log_location
    touch $product_log
fi

nohup java -javaagent:$agent_location/product-ms/skywalking-agent.jar -jar $productms 2>> $product_log >> /dev/null &
echo $! > $productmsPID

echo "Starting image ms"
image_log=$log_location/image-ms.log

if [ ! -f $dproduct_log ]; then
    mkdir -p $log_location
    touch $image_log
fi

nohup java -javaagent:$agent_location/image-ms/skywalking-agent.jar -jar $imagems 2>> $image_log >> /dev/null &
echo $! > $imagemsPID

echo "Starting order ms"
order_log=$log_location/order-ms.log

if [ ! -f $order_log ]; then
    mkdir -p $log_location
    touch $order_log
fi

nohup java -javaagent:$agent_location/order-ms/skywalking-agent.jar -jar $orderms 2>> $order_log >> /dev/null &
echo $! > $ordermsPID

echo "Starting eureka server"
eureka_log=$log_location/eureka.log

if [ ! -f $eureka_log ]; then
    mkdir -p $log_location
    touch $eureka_log
fi
#-javaagent:$agent_location/eureka/skywalking-agent.jar
nohup java  -jar $eureka 2>> $eureka_log >> /dev/null &
echo $! > $eurekaPID



echo "Starting gateway"
gw_log=$log_location/gateway.log

if [ ! -f $gw_log ]; then
    mkdir -p $log_location
    touch $gw_log
fi
nohup java -javaagent:$agent_location/gateway/skywalking-agent.jar -jar $gateway 2>> $gw_log >> /dev/null &
echo $! > $gatewayPID

echo "Starting webui"
ui_log=$log_location/web-ui.log

if [ ! -f $ui_log ]; then
    mkdir -p $log_location
    touch $ui_log
fi
nohup java -javaagent:$agent_location/webui/skywalking-agent.jar -jar $webui 2>> $ui_log >> /dev/null &
echo $! > $webuiPID
