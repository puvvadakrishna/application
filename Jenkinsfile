pipeline {
    agent any
     tools {
         maven 'maven-3.9.6'
     }
    stages {
             stage('Initialize'){
                steps{
                    echo "Step that saw"
                    sh 'mvn --version'
                }
            }
            stage('Build') {
                steps {
                    sh 'mvn clean install -DskipTests=true'
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
