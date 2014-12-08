FROM java
RUN apt-get install -qq -y wget
RUN wget -nv https://download.elasticsearch.org/logstash/logstash/logstash-1.4.1.tar.gz ; tar xzf logstash-1.4.1.tar.gz
ADD logstash.conf logstash.conf
VOLUME /log
CMD logstash-1.4.1/bin/logstash -f logstash.conf
