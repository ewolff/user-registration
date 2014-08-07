Description
===========

Installs a Java web application on Tomcat. The web application might
either be copied from a web server or from the cookbook itself.

Requirements
============

Platform: 

* Debian, Ubuntu (OpenJDK, Sun)
* CentOS, Red Hat, Fedora (OpenJDK)

The following Opscode cookbooks are dependencies:

* tomcat

Attributes
==========

*  :node["webapp"]["webapp"] Web application to be deployed
*  :node["webapp"]["webserver"] Web server to copy the application
   from
*  :node["webapp"]["remote_deploy"] Boolean: deploy from web server?

Usage
=====


License and Author
==================

Author:: Eberhard Wolff (eberhard.wolff@gmail.com)

Copyright:: 2010, Eberhard Wolff

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
