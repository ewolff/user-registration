* run ./install-modules.sh to install 3rd party Puppet modules
* optionally install the vagrant-cachier plugin to make subsequent creations of the box faster (https://github.com/fgrehm/vagrant-cachier)
* run 'vagrant up' to create the playground (takes quite a while at the first time)

Afterwards, the following components are available:
* Jenkins -> 192.168.33.100:9191
* Artifactory -> 192.168.33.100:9292
* SonarQube -> 192.168.33.100:9393
