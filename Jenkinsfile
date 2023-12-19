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
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        }
}
