pipeline {
    agent any

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
