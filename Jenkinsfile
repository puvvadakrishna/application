pipeline {
    agent {
     docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
         stage('Initialize'){
            steps{
                echo "M2_HOME = /opt/maven"
                echo "PATH = ${M2_HOME}/bin:${PATH}"
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
