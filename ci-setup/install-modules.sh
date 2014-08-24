#!/bin/bash

PUPPET_BINARY='which puppet'
MODULES_DIRECTORY='/vagrant/modules_ext'

if [ -z "${PUPPET_BINARY}"]; then
  echo "Puppet not installed! Please install it and run script again."
  exit 1
fi

if [ ! -e "${MODULES_DIRECTORY}/jenkins" ]; then
  puppet module install rtyler-jenkins --target-dir $MODULES_DIRECTORY
fi
if [ ! -e "${MODULES_DIRECTORY}/sonarqube" ]; then
  puppet module install maestrodev-sonarqube --target-dir $MODULES_DIRECTORY
fi
if [ ! -e "${MODULES_DIRECTORY}/mysql" ]; then
  puppet module install puppetlabs-mysql --target-dir $MODULES_DIRECTORY
fi

if [ ! -e "${MODULES_DIRECTORY}/artifactory" ]; then
  cd /tmp
  apt-get install -y unzip
  wget https://github.com/moolsan/puppet-artifactory/archive/master.zip
  unzip master.zip -d $MODULES_DIRECTORY
  mv $MODULES_DIRECTORY/puppet-artifactory-master/ $MODULES_DIRECTORY/artifactory
  rm master.zip
fi
