pipeline {
      agent { docker { image 'maven:3.9.6'} }
        stages {
           stage('Build') {
             steps {
                echo "Build"
                echo "JOB_URL - $env.JOB_URL"
             }
           }
            stage('Test') {
                        steps {
                           echo "Test"
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
