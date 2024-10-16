pipeline {
     agent any
//      {
//           docker {
//               image 'maven:3.9.3'
//               args '-v /root/.m2:/root/.m2' // Optional: to cache Maven dependencies
//           }
//       }
    stages {
             stage('Initialize'){
                steps{
                    echo "Step that saw"
                    sh 'mvn --version'
                }
            }
            stage('Build') {
             steps {
                   script {
                                docker.withServer('unix:///var/run/docker.sock') {
                                    sh 'docker --version'
                                    sh 'mvn clean install -U -DskipTests=true'
                                }
                             }
                    }
            }
            stage('Test') {
                steps {
                    sh 'mvn test'
                }
            }
        }

     post{
          success {
                mail to: 'Sowmyasreekollipara@gmail.com , puvvada.krishna@gmail.com',
                     subject: "Build successful: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: """Build ${env.JOB_NAME} - #${env.BUILD_NUMBER} has failed.
                              Check console output at <a href="${env.BUILD_URL}">${env.BUILD_URL}</a>"""
                  }
          failure {
               mail to: 'Sowmyasreekollipara@gmail.com , puvvada.krishna@gmail.com',
                    subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """Build ${env.JOB_NAME} - #${env.BUILD_NUMBER} has failed.
                             Check console output at <a href="${env.BUILD_URL}">${env.BUILD_URL}</a>"""
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
