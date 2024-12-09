#!/bin/bash

installJava() {
    echo "*************************************************************************START Installing Java 17 *******************************************************************************************"
    sudo yum install -y java-17-amazon-corretto
    echo "*************************************************************************END Installing java 17**********************************************************************************************"
}


installGit() {
    echo "*************************************************************************=START Installing git**********************************************************************************************"
    sudo yum install git -y
    echo "*************************************************************************=====END installing git*********************************************************************************************"
}


installDocker() {
    echo "*************************************************************************START Installing docker**********************************************************************************************"
    sudo yum install docker -y
    sudo systemctl start docker
    sudo systemctl enable docker
    echo "*************************************************************************=END installing docker***********************************************************************************************"
}

installHttpd() {

    echo "*************************************************************************START Installing httpd server****************************************************************************************"
    yum install httpd -y
    systemctl start httpd
    systemctl enable httpd
    TOKEN=$(curl -X PUT "http://169.254.169.254/latest/api/token" -H "X-aws-ec2-metadata-token-ttl-seconds: 21600")
    curl -H "X-aws-ec2-metadata-token: $TOKEN" http://169.254.169.254/latest/dynamic/instance-identity/document  > /var/www/html/index.html
    echo "****************************************************************************END Installing http**********************************************************************************************"
}

installJenkins() {
    echo "***********************************************************************START Jenkins installing**********************************************************************************************"
    echo "Installing jenkins"

    sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat/jenkins.repo
    sudo rpm --import https://pkg.jenkins.io/redhat/jenkins.io.key

    # wget -O /tmp/jenkins.io.key https://pkg.jenkins.io/redhat-stable/jenkins.io.key
    # sudo rpm --import /tmp/jenkins.io.key

    sudo yum clean all
    sudo yum install jenkins -y --nogpgcheck
    sudo systemctl enable jenkins
    sudo usermod -aG docker jenkins
    sudo systemctl restart jenkins
    sudo cat /var/lib/jenkins/secrets/initialAdminPassword

    echo "*************************************************************************=END installing jenkins**********************************************************************************************"
}

installJava
installGit
installDocker
installHttpd
installJenkins