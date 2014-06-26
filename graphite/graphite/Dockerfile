FROM ubuntu-update
MAINTAINER eberhard.wolff@gmail.com
RUN apt-get install -y python3 python3-minimal python-cairo-dev python-django python-ldap python-memcache python-pysqlite2 sqlite3 python-setuptools
RUN apt-get install -y build-essential python2.7-dev
RUN wget --no-check-certificate http://launchpad.net/graphite/0.9/0.9.9/+download/graphite-web-0.9.9.tar.gz
RUN wget --no-check-certificate http://launchpad.net/graphite/0.9/0.9.9/+download/carbon-0.9.9.tar.gz
RUN wget --no-check-certificate http://launchpad.net/graphite/0.9/0.9.9/+download/whisper-0.9.9.tar.gz
RUN tar -zxvf graphite-web-0.9.9.tar.gz
RUN tar -zxvf carbon-0.9.9.tar.gz
RUN tar -zxvf whisper-0.9.9.tar.gz
RUN mv graphite-web-0.9.9 graphite
RUN mv carbon-0.9.9 carbon
RUN mv whisper-0.9.9 whisper
RUN rm carbon-0.9.9.tar.gz
RUN rm graphite-web-0.9.9.tar.gz
RUN rm whisper-0.9.9.tar.gz
RUN easy_install zope.interface
RUN easy_install twisted
RUN easy_install txamqp
RUN easy_install django-tagging==0.3.1
RUN easy_install daemonize
RUN cd whisper ; python setup.py install
RUN cd carbon ; python setup.py install
RUN cd /opt/graphite/conf ; cp carbon.conf.example carbon.conf ; cp storage-schemas.conf.example storage-schemas.conf
RUN cp graphite/conf/graphite.wsgi.example /opt/graphite/conf/graphite.wsgi
RUN cd graphite ; python check-dependencies.py ; python setup.py install
ADD local_settings.py /opt/graphite/webapp/graphite/
ADD settings.py /opt/graphite/webapp/graphite/settings.py
RUN cd /opt/graphite/webapp/graphite ; python manage.py syncdb --noinput ;  chown -R www-data:www-data /opt/graphite/storage/
RUN sed -i 's/^from twisted.scripts._twistd_unix //' /opt/graphite/lib/carbon/util.py
ADD run.sh run.sh
CMD /bin/bash run.sh
EXPOSE 80 2003




