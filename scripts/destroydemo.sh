#!/bin/sh
cd chef
vagrant destroy -f
cd ..
cd graphite
vagrant destroy -f
cd ..
cd log-analysis
vagrant destroy -f
cd ..
cd shell
vagrant destroy -f
cd ..
