FROM java
RUN apt-get install -y wget ; wget https://download.elasticsearch.org/logstash/logstash/logstash-1.4.1.tar.gz ; tar xvzf logstash-1.4.1.tar.gz
ADD logstash.conf logstash.conf
VOLUME /log
CMD logstash-1.4.1/bin/logstash -f logstash.conf
