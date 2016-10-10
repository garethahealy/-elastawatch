[![Build Status](https://travis-ci.org/garethahealy/elastawatch.svg?branch=master)](https://travis-ci.org/garethahealy/elastawatch)
[![Release Version](https://img.shields.io/maven-central/v/com.garethahealy.elastawatch/elastawatch-parent.svg?maxAge=2592000)](https://mvnrepository.com/artifact/com.garethahealy.elastawatch/elastawatch-parent)
[![License](https://img.shields.io/hexpm/l/plug.svg?maxAge=2592000)]()

# elastawatch
PoC to see how ElasticSearch Watcher works.
- https://www.elastic.co/products/watcher

## Building
This project containers everything need to run the example. To build the Camel Loader:

    mvn clean install

To downlaod and install ElasticSearch with the required plugins and Kibana:
    
    /elasticsearch/1_install.sh
    /kibana/1_install.sh

## Running
To run the examples, follow the below order, firstly start ElasticSearch

    /elasticsearch/2_run.sh
    
Then Kibana (useful for visualising the logs):

    /kibana/2_run.sh
    
Now create the example watcher:

    /watcher/create.sh example-watcher.json

Start up the loader:

    cd elastic-loader
    mvn camel:run

And finally, copy the example file into the running loader:

    cp elastic-loader/src/main/resources/example.json elastic-loader/target/json/

The file should be processed, loaded into ElasticSearch and you should now start to see the following log message in ElasticSearch:

    [2016-10-04 16:16:38,839][INFO ][watcher.actions.logging  ] [Fontanelle] Found 1 'elasticsearchLoad started' in the logs
