#!/usr/bin/env bash
source env.sh

if [ -f $productmsPID ]; then
    PID=$(cat $productmsPID);
    kill $PID;
    rm $productmsPID
else
    echo "product ms is not running"
fi


if [ -f $imagemsPID ]; then
    PID=$(cat $imagemsPID);
    kill $PID;
    rm $imagemsPID
else
    echo "image ms is not running"
fi


if [ -f $ordermsPID ]; then
    PID=$(cat $ordermsPID);
    kill $PID;
    rm $ordermsPID
else
    echo "order ms is not running"
fi

if [ -f $eurekaPID ]; then
    PID=$(cat $eurekaPID);
    kill $PID;
    rm $eurekaPID
else
    echo "eureka is not running"
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