pipeline {
     agent {
          docker {
              image 'maven:3.9.3'
              args '-v /root/.m2:/root/.m2' // Optional: to cache Maven dependencies
          }
      }
    stages {
             stage('Initialize'){
                steps{
                    echo "Step that saw"
                    sh 'mvn --version'
                }
            }
            stage('Build') {
             script {
                        docker.withServer('unix:///var/run/docker.sock') {
                            sh 'docker --version'
                            sh 'mvn clean install -U -DskipTests=true'
                        }
                 }
             }
             stage('Test') {
                steps {
                    sh 'mvn test'
                }
            }
        }

     post{
         success{
            echo 'Build successful'
         }
         failure{
            echo 'Build failure'
         }
         always{
            echo 'job executed'
         }
         aborted{
            echo 'Build aborted'
         }
         changed{
            echo 'Build state changed, please take a look!'
         }
     }
}
