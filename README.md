[![Build Status](https://travis-ci.org/garethahealy/elastawatch.svg?branch=master)](https://travis-ci.org/garethahealy/elastawatch)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.garethahealy.elastawatch:elastawatch-parent&metric=coverage)](https://sonarcloud.io/dashboard?id=com.garethahealy.elastawatch%3Aelastawatch-parent)
[![Release Version](https://img.shields.io/maven-central/v/com.garethahealy.elastawatch/elastawatch-parent.svg?maxAge=2592000)](https://mvnrepository.com/artifact/com.garethahealy.elastawatch/elastawatch-parent)
[![License](https://img.shields.io/hexpm/l/plug.svg?maxAge=2592000)]()

# elastawatch
PoC to see how ElasticSearch Watcher works.
- https://www.elastic.co/products/x-pack/alerting

## Building
This project contains everything needed to run the example:

1. Build the Camel Loader:

    mvn clean install

2. Download and install ElasticSearch/Kibana with the required plugins
    
    ./elasticsearch/1_install.sh
    ./kibana/1_install.sh

## Running
To run the examples, follow the below order:

1. Start ElasticSearch

    ./elasticsearch/2_run.sh
    
2. Start Kibana (useful for visualising the logs):

    ./kibana/2_run.sh
    
3. Create the example watcher:

    ./watcher/create.sh ./watcher/example-watcher.json

4. Start up the loader:

    cd elastic-loader
    mvn camel:run

5. Copy the example file into the running loader:

    cp elastic-loader/src/main/resources/example.json elastic-loader/target/json/

The file should be processed, loaded into ElasticSearch and you should now start to see the following log message in ElasticSearch:

    [2016-10-04 16:16:38,839][INFO ][watcher.actions.logging  ] [Fontanelle] Found 1 'elasticsearchLoad started' in the logs
