User Registration
===========

[German / Deutsch](LIESMICH.md)

This is an example that shows basic technical features
for an application that should run in a Continuous Delivery
Pipeline. The focus is to provide a playground that you can build your
own experiments on. Orignally it was intended as an example for the [German
Continuous Delivery book](https://bit.ly/CD-Buch-Amzn) .

The application is written in Java and uses Spring Boot. To compile
and execute all tests:

- Install Maven
- Execute `mvn install` in this directory.

At least some parts of the code are in German - sorry about that.

As part of the Maven build the following projects are built:

- The subdir `user-registration-application` containst the application
  itself. It is compiled and unit tests are execeuted.
- The subdir `user-registration-acceptancetest-jbehave` contains
  automated acceptance tests implemented with JBehave. This tools
  allows you to write tests as stories in natural language. 
- The subdir `user-registration-acceptancetest-selenium` contains
  automated acceptance tests implemented with Selenium. They are run
  through the Web GUI.
- Finally the subdir `user-registration-acceptancetest-gatling` contains
  automated capacity tests implemented with Gatling. These are
  executed throught the Web GUI.

Additionally to these projects built by Maven additional projects are provided:

- The subdir `docker` contains a setup to install the application in a
  Docker container in a Vagrant box. Docker is a lightweight approach
  that uses Linux Containers to provide an easy way to install
  applications in their own independent environment  - almost like
  virtual machines. Vagrant makes using such technologies much easier.
- Based on this setup the subdir `graphite` contains a setup to run
  the application and have the monitoring information available
  through graphite.
- The subdir `log-analysis` contains a setup to run the application
  and analyze the log information using Logstash. The information is
  then stored in Elasticsearch and can be analyzed using Kibana.
 - The subdir `chef` contains a sample for a Chef setup.
 - In the subdir `shell` you can find an example how the application
   can be provisioned using a simple shell script.
   

Please note that you need to execute the Maven build before you can
run these additional projects. You will find more information about
the projects in the README.md file in the corresponding subdir.

The code is provided under Apache 2.0 license - see the file LICENSE
in this dir.

PLEASE NOTE: This example is not production ready. For example some of
the services run as root even though they can be accessed through the
net. This poses a security thread.
