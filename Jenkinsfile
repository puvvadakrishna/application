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
                emailext(
                                     subject: "Build success: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                                     body: """
                                         <p>Build <b>${env.BUILD_NUMBER}</b> of job '${env.JOB_NAME}' failed.</p>
                                         <p>See the details at <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                                     """,
                                     to: 'puvvada.krishna@gmail.com'
                        )
         }
        failure {
                 emailext(
                     subject: "Build Failure: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                     body: """
                         <p>Build <b>${env.BUILD_NUMBER}</b> of job '${env.JOB_NAME}' failed.</p>
                         <p>See the details at <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                     """,
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
