pipeline {
     agent {
          docker {
              image 'maven:3.6.3'
              args '-v /root/.m2:/root/.m2' // Optional: to cache Maven dependencies
          }
      }
    stages {
             stage('Initialize'){
                steps{
                    echo "Step that saw"
                    sh 'mvn --verssssion'
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
         failure {
             echo 'Build failure'
             emailext(
                 subject: "BUILD FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                 body: """<p>Build <b>${env.BUILD_NUMBER}</b> failed. Check the Jenkins console output <a href="${env.BUILD_URL}console">${env.BUILD_URL}console</a>.</p>""",
                 to: 'puvvada.krishna@gmail.com'
             )
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
