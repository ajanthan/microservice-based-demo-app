#!/usr/bin/env bash
source env.sh

if [ -f $dataservicePID ]; then
    PID=$(cat $dataservicePID);
    kill $PID;
    rm $dataservicePID
else
    echo "dataservice is not running"
fi

if [ -f $bussinessservicePID ]; then
    PID=$(cat $bussinessservicePID);
    kill $PID;
    rm $bussinessservicePID
else
    echo "bussinessservice is not running"
fi

if [ -f $gatewayPID ]; then
    PID=$(cat $gatewayPID);
    kill $PID;
    rm $gatewayPID
else
    echo "gateway is not running"
fi


if [ -f $webuiPID ]; then
    PID=$(cat $webuiPID);
    kill $PID;
    rm $webuiPID
else
    echo "web-ui is not running"
fi