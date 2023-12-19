pipeline {
    agent any
      tools {
         maven 'maven-3.6.3' 
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
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
