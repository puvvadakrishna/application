pipeline {
     agent any
//      {
//           docker {
//               image 'maven:3.9.3'
//               args '-v /root/.m2:/root/.m2' // Optional: to cache Maven dependencies
//           }
//       }
    tools {
         maven 'maven'
     }
    environment {
        dockerHome = tool 'docker'
        mavenHome = tool 'maven'
        PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }
    stages {
             stage('Echo to see information about builds'){
                steps{
                    echo "Docker host -  $env.DOCKER_HOST"
                    echo "BUILD_TAG -  $env.BUILD_TAG"
                    echo "Step that saw"
                    sh 'mvn --version'
                    sh 'docker --version'

                }
            }
             stage('Clean') {
                    steps {
                        sh 'mvn clean'
                    }
             }
//             stage('Parallel Stages') {
//                     parallel {
             stage('Compile') {
                     steps {
                               sh 'mvn compile'
                           }
             }
            stage('Test') {
                steps {
                    sh 'mvn test -X'
                }
            }
            stage('Package') {
                 steps {
                             sh 'mvn package -U -DskipTests=true'
                 }
            }
            stage('Install') {
                 steps {
                            sh 'mvn clean install -U -DskipTests=true'
                 }
             }
            stage('Build Docker image') {
                 steps {
                        echo "TO-DO docker images steps"
                   }
            }
    }

     post{
          success {
                mail from: 'jenkins-notifications',
                     to: 'sowmyasreekollipara@gmail.com , puvvada.krishna@gmail.com',
                     subject: "Build successful: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: """Build ${env.JOB_NAME} - #${env.BUILD_NUMBER} is good.
                              Check console output at <a href="${env.BUILD_URL}">${env.BUILD_URL}</a>"""
                  }
          failure {
               mail from: 'jenkins-notifications',
                    to: 'sowmyasreekollipara@gmail.com , puvvada.krishna@gmail.com',
                    subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """Build ${env.JOB_NAME} - #${env.BUILD_NUMBER} has failed.
                             Check console output at <a href="${env.BUILD_URL}">${env.BUILD_URL}</a>"""
          }
          always{
                echo 'job executed'
                 mail from: 'jenkins-notifications',
                    to: 'sowmyasreekollipara@gmail.com , puvvada.krishna@gmail.com',
                    subject: "Build Triggered: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """Build ${env.JOB_NAME} - #${env.BUILD_NUMBER} has failed.
                             Check console output at <a href="${env.BUILD_URL}">${env.BUILD_URL}</a>"""
          }
          aborted{
            echo 'Build aborted'
          }
          changed{
             echo 'Build state changed, please take a look!'
          }
      }
}