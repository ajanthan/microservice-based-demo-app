#!/usr/bin/env bash
es_version=5.5.0
unzip elasticsearch-$es_version.zip -d working
rsync -avz  elasticsearch.yml elasticsearch-$es_version/config