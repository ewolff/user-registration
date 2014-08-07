current_dir = File.dirname(__FILE__)
log_level                :info
log_location             STDOUT
node_name                'ewolff'
## change to value of client_key below - without file extension

####### Amnazon

knife[:aws_access_key_id]      = ENV['AWS_ACCESS_KEY_ID']
knife[:aws_secret_access_key]  = ENV['AWS_SECRET_ACCESS_KEY']
## AWS ACCESS KEY and ID - get it from https://portal.aws.amazon.com/gp/aws/securityCredentials
## and set it as an environment variable

knife[:aws_ssh_key_id] = 'EU-WEST-EW'
## ssh_key Get it from https://console.aws.amazon.com/ec2/v2/home?region=eu-west-1#KeyPairs: 
knife[:ssh_user]       = 'ubuntu'
knife[:region]         = 'eu-west-1'
knife[:flavor]         = 't1.micro'

knife[:image]          = 'ami-a0e81fd7'
## this is an Ubuntu 10.04 LTS image
 knife[:groups]        = 'default'
## security group - create it at https://console.aws.amazon.com/ec2/home?region=eu-west-1#s=SecurityGroups
## ensure port 8080 ist made availabele

###### Hosted Chef

client_key               "#{current_dir}/ewolff.pem"
## assure the client key is in the current directory
## get it from https://www.getchef.com/account/password
validation_client_name   'test-org42-validator'
## change validation_client-name to <your-organization>-validator
validation_key           "#{current_dir}/test-org42-validator.pem"
## change validation key to '#{current_dir}/<your-organization>-validator.pem'
## and assure its present in the current directory
## get it from https://manage.opscode.com/organizations
chef_server_url          'https://api.opscode.com/organizations/test-org42'
## change to  https://api.opscode.com/organizations/<your-organization>
cache_type               'BasicFile'
cache_options( :path => "#{current_dir}/checksums" )
cookbook_path            ["#{current_dir}/../cookbooks"]


