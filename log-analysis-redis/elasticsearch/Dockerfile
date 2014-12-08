FROM java
RUN apt-get install -qq -y wget
RUN wget -nv http://download.elasticsearch.org/elasticsearch/elasticsearch/elasticsearch-1.2.1.tar.gz ; tar xzf elasticsearch-1.2.1.tar.gz 
CMD elasticsearch-1.2.1/bin/elasticsearch
EXPOSE 9200