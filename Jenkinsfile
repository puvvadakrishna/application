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
            echo 'Build successful'
         }
         always{
            echo 'job executed'
         }
     }
}
