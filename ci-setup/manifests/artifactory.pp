class { 'artifactory::config' :
  version       => '3.3.0',
  user          => 'artifactory',
  group         => 'artifactory',
  port          => 9292,
  manage_java   => false,
}

include artifactory
