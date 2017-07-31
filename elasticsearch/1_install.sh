#!/usr/bin/env bash

curl -L -O https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-5.5.0.tar.gz
tar -xvf elasticsearch-5.5.0.tar.gz

elasticsearch-5.5.0/bin/elasticsearch-plugin install --batch x-pack
echo "xpack.security.enabled: false" >> elasticsearch-5.5.0/config/elasticsearch.yml
