# declare order
Class['mysql::server'] -> Class['sonarqube']

# set up SonarQube database
class { "mysql::server" :
  databases     => {
    'sonar' => {
      ensure  => 'present',
      charset => 'utf8',
    }
  },
  users => {
    "sonar@localhost" => {
      ensure => 'present',
      password_hash => mysql_password('sonar'),
    }
  },
  grants => {
    'sonar@localhost/sonar.*' => {
      ensure     => 'present',
      options    => ['GRANT'],
      privileges => ['ALL'],
      table      => 'sonar.*',
      user       => 'sonar@localhost',
    }
  }
}

# install SonarQube 4.4
class { 'sonarqube' :
  version => '4.4',
  port    => '9393',
  jdbc    => {
    url       => 'jdbc:mysql://localhost:3306/sonar?useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true',
    username  => 'sonar',
    password  => 'sonar',
  }
}
