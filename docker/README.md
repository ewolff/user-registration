Example using Docker
==============

This creates a VM with the application in a Docker container. To run:
- Install Vagrant as discussed at
  http://docs.vagrantup.com/v2/installation/index.html
 - Install Virtual Box from https://www.virtualbox.org/wiki/Downloads
 - Go to parent directory and run `mvn install` there
 - Change to the directoriy containing this README.MD and run `vagrant
   up`

The result should be:
- A new VirtualBox VM is fired up by Vagrant
- Docker is installed in the VM
- You can access the application at http://localhost:8090/

