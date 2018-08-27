#!/usr/bin/env bash

elasticsearch-6.4.0/bin/elasticsearch

#Setup a trial license for watcher
curl -XPOST 'http://localhost:9200/_xpack/license/start_trial?acknowledge=true'
