#!/usr/bin/env bash
apm_version=5.0.0-alpha

unzip apache-skywalking-apm-incubating-$apm_version.zip -d working
rsync -avz --exclude apache-skywalking-apm-incubating/config apache-skywalking-apm-incubating/agent ../agents/business-service
rsync -avz --exclude apache-skywalking-apm-incubating/config apache-skywalking-apm-incubating/agent ../agents/data-service
rsync -avz --exclude apache-skywalking-apm-incubating/config apache-skywalking-apm-incubating/agent ../agents/gateway
rsync -avz --exclude apache-skywalking-apm-incubating/config apache-skywalking-apm-incubating/agent ../agents/webui