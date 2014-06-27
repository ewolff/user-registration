#!/bin/sh
rm /opt/graphite/storage/carbon-cache-a.pid 
/opt/graphite/bin/carbon-cache.py start
python /opt/graphite/webapp/graphite/manage.py runserver 0.0.0.0:80 
