Graphite for Monitoring
===============

This project creates a VM with the application in a Docker container and a separate Docker container for Graphite. Graphite can be used as a monitoring tool for the application.

To run:

- Install Vagrant as discussed at
  http://docs.vagrantup.com/v2/installation/index.html
- Install Virtual Box from https://www.virtualbox.org/wiki/Downloads
- Go to parent directory and run `mvn install` there
- Change to the directoriy containing this README.MD and run `vagrant
   up`

The result should be:

- A new VirtualBox VM is fired up by Vagrant
- Docker is installed in the VM
- You can access the application at http://localhost:8083/
- You can access Graphite  at http://localhost:8082/
- Graphite's port to add data to the monitoring is also exposed at 2003

