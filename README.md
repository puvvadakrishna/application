# app

Oracle docker installations steps

1. docker pull truevoly/oracle-12c

2. docker run -d -p 8085:8080 -p 1521:1521 -v D:/oracle/oradata:/u01/app/oracle truevoly/oracle-12c


1. docker system prune -a --volumes
2. docker run --name jenkins-docker --rm --detach --privileged --network jenkins --network-alias docker --env
   DOCKER_TLS_CERTDIR=/certs --volume jenkins-docker-certs:/certs/client --volume jenkins-data:/var/jenkins_home
   --publish 2376:2376 docker:dind
3. run the docker file
4. docker run --name jenkins-blueocean --restart=on-failure --detach --network jenkins --env DOCKER_HOST=tcp://docker:
   2376 --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1 --volume jenkins-data:/var/jenkins_home --volume
   jenkins-docker-certs:/certs/client:ro --publish 8080:8080 --publish 50000:50000 myjenkins-blueocean:2.462.3-1