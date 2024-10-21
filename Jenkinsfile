pipeline {
        //agent any
      agent { docker { image 'maven:3.9.6'} }
      environment
          {
            dockerHome = tool 'myDocker'
            mavenHome = tool 'maven-3.9.6'
            PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
      }
        stages {
           stage('Build') {
             steps {
                sh 'mvn --version'
                sh 'docker --version'
                echo "Build"
                echo "JOB_URL - $env.JOB_URL"
                echo "JOB_NAME - $env.JOB_NAME"
                echo "BUILD_NUMBER - $env.BUILD_NUMBER"
                echo "BUILD_ID - $env.BUILD_ID"
                echo "BUILD_URL - $env.BUILD_URL"
                echo "BUILD_TAG - $env.BUILD_TAG"
             }
           }
           stage('compile') {
             steps {
                sh "mvn clean compile"
             }
             }
            stage('Test') {
                        steps {
                           sh "mvn test"
                           //echo "Test"
                        }
                      }
             stage('Integration Test') {
                         steps {
                            echo "Integration Test"
                         }
                       }
        }
        post {
              always {
                   echo 'I run always'
              }
              success {
                   echo  'I run when you are succesful'
              }
              failure {
                   echo  'I run when you fail'
              }
        }
}
