#!/bin/sh
cd chef
vagrant up
vagrant halt
cd ..
cd graphite
vagrant up
vagrant halt
cd ..
cd log-analysis
vagrant up
vagrant halt
cd ..
cd shell
vagrant up
vagrant halt
cd ..
