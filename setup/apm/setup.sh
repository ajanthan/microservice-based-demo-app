#!/usr/bin/env bash
apm_version=${version:=5.0.0-alpha}
mkdir -p working
tar -xvzf apache-skywalking-apm-incubating-$apm_version.tar.gz -C working
rsync -avz --exclude config working/apache-skywalking-apm-incubating/agent/ ../agents/business-service
rsync -avz --exclude config working/apache-skywalking-apm-incubating/agent/ ../agents/data-service
rsync -avz --exclude config working/apache-skywalking-apm-incubating/agent/ ../agents/gateway
rsync -avz --exclude config working/apache-skywalking-apm-incubating/agent/ ../agents/webui