[![Build Status](https://travis-ci.org/garethahealy/elastawatch.svg?branch=master)](https://travis-ci.org/garethahealy/elastawatch)

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
To run the examples, follow the below order:

    /elasticsearch/2_run.sh
    
Then:

    /kibana/2_run.sh

And finally:

    cd elastic-loader
    mvn camel:run
