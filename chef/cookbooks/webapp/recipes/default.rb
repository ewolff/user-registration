#
# Cookbook Name:: webapp
# Recipe:: default
#
# Copyright 2010, YOUR_COMPANY_NAME
#
# All rights reserved - Do Not Redistribute
#
include_recipe "tomcat"

if node["webapp"]["remote_deploy"]
# remote deployment: get file from web site

remote_file node["tomcat"]["webapp_dir"]+"/"+node["webapp"]["webapp"]  do
    notifies :restart, resources(:service => "tomcat")
    source node["webapp"]["webserver"] + node["webapp"]["webapp"]
    owner "root"
    group "root"
    mode "0644"
end

else
  # local deployment by copying a file
  cookbook_file node["tomcat"]["webapp_dir"]+"/"+node["webapp"]["webapp"] do
    notifies :restart, resources(:service => "tomcat")
    source node["webapp"]["webapp"]
    owner "root"
    group "root"
    mode "0644"
  end
end
