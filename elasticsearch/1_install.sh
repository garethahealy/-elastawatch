#!/usr/bin/env bash

curl -L -O https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-6.4.0.tar.gz
tar -xvf elasticsearch-6.4.0.tar.gz

echo "xpack.security.enabled: false" >> elasticsearch-6.4.0/config/elasticsearch.yml
