#!/bin/bash

PUPPET_BINARY='which puppet'

if [ -z "${PUPPET_BINARY}"]; then
  echo "Puppet not installed! Please install it and run script again."
  exit 1
fi

if [ ! -e modules_ext ]; then
  mkdir modules_ext
fi

puppet module install rtyler-jenkins --target-dir modules_ext
puppet module install maestrodev-sonarqube --target-dir modules_ext
puppet module install puppetlabs-mysql --target-dir modules_ext

wget https://github.com/moolsan/puppet-artifactory/archive/master.zip
unzip master.zip -d modules_ext/
mv modules_ext/puppet-artifactory-master/ modules_ext/artifactory
rm master.zip
