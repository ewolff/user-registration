VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "lucid32"
  config.vm.box_url="http://files.vagrantup.com/lucid32.box"

  config.vm.network "forwarded_port", guest: 8080, host: 18080
  config.vm.network "forwarded_port", guest: 8081, host: 18081

  config.vm.provision "chef_solo" do |chef|
    chef.cookbooks_path = ["cookbooks"]
    chef.roles_path=["roles"]
    chef.add_role("tomcatserver")
  end

end
