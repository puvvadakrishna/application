pipeline {
    agent {
     docker {
            image 'maven:3-alpine' 
            args '-u root'
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
