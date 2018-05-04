#!/usr/bin/env bash

collector_pid=$(jps | grep "CollectorBootStartUp" | awk '{print $1}')
kill -9 $collector_pid
webapp_pid=$(jps | grep "skywalking-webapp.jar" | awk '{print $1}')
kill -9 $webapp_pid