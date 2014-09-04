# setup jenkins
class { 'jenkins' :
  config_hash => {
    'HTTP_PORT' => { 'value' => '9191' }
  }
}

# install a bunch of useful plugins
$plugins = [
  'credentials',
  'ssh-credentials',
  'git-client',
  'scm-api',
  'git',
  'jquery',
  'jobConfigHistory',
  'parameterized-trigger',
  'build-pipeline-plugin',
  'disk-usage',
  'monitoring',
  'ws-cleanup',
  'envinject',
  'sonar'
]

jenkins::plugin { $plugins : }

# install git package
package { 'git' :
  ensure => installed,
}
