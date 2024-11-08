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
             stage('Compile') {
                     steps {
                               sh 'mvn compile'
                           }
             }
            stage('Test') {
                steps {
                        echo "skipping test to save ec2!"
                }
            }
            stage('Package') {
                 steps {
                           echo "skipping Package to save ec2!"
                 }
            }
            stage('Install') {
                 steps {
                           echo "skipping Install to save ec2!"
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
                     to: 'puvvada.krishna@gmail.com',
                     subject: "AWS Build successful: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: """Check console output at ${env.BUILD_URL}"""
                  }
          failure {
               mail from: 'jenkins-notifications',
                    to: 'puvvada.krishna@gmail.com',
                    subject: "AWS Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """Check console output at ${env.BUILD_URL}"""

          }
          always{
                echo 'job executed'
                 mail from: 'jenkins-notifications',
                    to: 'puvvada.krishna@gmail.com',
                    subject: "AWS Build Triggered: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """Check console output at ${env.BUILD_URL}"""

          }
          aborted{
            echo 'Build aborted'
          }
          changed{
             echo 'Build state changed, please take a look!'
          }
      }
}