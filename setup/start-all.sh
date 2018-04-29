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

echo "Starting dataservice"
ds_log=$log_location/data-service.log

if [ ! -f $ds_log ]; then
    mkdir -p $log_location
    touch $ds_log
fi

nohup java -javaagent:$agent_location/data-service/skywalking-agent.jar -jar $dataservice 2>> $ds_log >> /dev/null &
echo $! > $dataservicePID

echo "Starting bussinessservice"
bs_log=$log_location/buiness-service.log

if [ ! -f $bs_log ]; then
    mkdir -p $log_location
    touch $bs_log
fi

nohup java -javaagent:$agent_location/business-service/skywalking-agent.jar -jar $bussinessservice 2>> $bs_log >> /dev/null &
echo $! > $bussinessservicePID

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
