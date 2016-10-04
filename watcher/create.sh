#!/usr/bin/env bash

jsonFile=$1

curl -XPUT --header "Content-Type: application/json" 'http://localhost:9200/_watcher/watch/log_error_watch' -d @$jsonFile
