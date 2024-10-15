pipeline {
     agent {
         docker {
             image 'maven:latest'
             args '-v /root/.m2:/root/.m2'
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
                    sh 'mvn clean install -U -DskipTests=true'
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
