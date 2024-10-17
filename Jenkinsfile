pipeline {
      agent { docker { image 'maven:3.9.6'} }
        stages {
           stage('Build') {
             steps {
                echo "Build"
                echo "JOB_URL - $env.http://localhost:8080/me/my-views/view/all/job/jenkins-devops-microservice%20pipeline/38/console"
                mail to: 'puvvada.krishna@gmail.com',
                    subject: "Job '${app/jenkins-poc}' (${38}) is waiting for input",
                    body: "Please go to ${http://localhost:8080/me/my-views/view/all/job/jenkins-devops-microservice%20pipeline/38/console} and verify the build"
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
