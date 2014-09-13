FROM ubuntu:14.04
RUN apt-get update ; apt-get dist-upgrade -y
RUN apt-get install -y redis-server
CMD redis-server
EXPOSE 6379