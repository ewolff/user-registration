#!/bin/sh
/opt/graphite/bin/carbon-cache.py start
python /opt/graphite/webapp/graphite/manage.py runserver 0.0.0.0:80 
