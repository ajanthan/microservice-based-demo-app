#!/usr/bin/env bash
apm_version=${version:=5.0.0-beta}
mkdir -p working
tar -xvzf apache-skywalking-apm-incubating-$apm_version.tar.gz -C working
rsync -avz --exclude config working/apache-skywalking-apm-incubating/agent/ ../agents/image-ms
rsync -avz --exclude config working/apache-skywalking-apm-incubating/agent/ ../agents/product-ms
rsync -avz --exclude config working/apache-skywalking-apm-incubating/agent/ ../agents/order-ms
rsync -avz --exclude config working/apache-skywalking-apm-incubating/agent/ ../agents/gateway
rsync -avz --exclude config working/apache-skywalking-apm-incubating/agent/ ../agents/eureka
rsync -avz --exclude config working/apache-skywalking-apm-incubating/agent/ ../agents/webui