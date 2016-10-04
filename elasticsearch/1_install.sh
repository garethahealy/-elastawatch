#!/usr/bin/env bash

curl -L -O https://download.elastic.co/elasticsearch/release/org/elasticsearch/distribution/tar/elasticsearch/2.4.1/elasticsearch-2.4.1.tar.gz
tar -xvf elasticsearch-2.4.1.tar.gz

elasticsearch-2.4.1/bin/plugin install --batch license
elasticsearch-2.4.1/bin/plugin install --batch watcher
