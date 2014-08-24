[German / Deutsch](LIESMICH.md)

# Continuous Integration setup

This box sets up a playground for Continuous Integration with Jenkins, Artifactory and SonarQube. You need Vagrant
installed on your computer to set it up. Optionally, installing the vagrant-cashier plugin might speed up subesequent 
creations of the box a lot, but it is not needed.

Running 'vagrant up' will install and setup all needed components. Notice that at the first execution, this may take 
quite a long time!

Afterwards, the following components are available:
* Jenkins ->     localhost:9191
* Artifactory -> localhost:9292
* SonarQube ->   localhost:9393
