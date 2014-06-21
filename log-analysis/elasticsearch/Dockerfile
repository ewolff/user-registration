FROM java
MAINTAINER eberhard.wolff@gmail.com
RUN apt-get install -y wget ; wget http://download.elasticsearch.org/elasticsearch/elasticsearch/elasticsearch-1.2.1.tar.gz ; tar xvzf elasticsearch-1.2.1.tar.gz 
CMD elasticsearch-1.2.1/bin/elasticsearch
EXPOSE 9200