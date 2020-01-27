pipeline {
  agent any
  stages {
    stage('System') {
      steps {
        sh 'pwd'
        sh 'echo $HOME;'
        sh 'docker --version;'
        sh 'java -version'
      }
    }

    stage('Build') {
      steps {
        sh 'ls -la'
        sh './gradlew build'
        archiveArtifacts(artifacts: '**/build/libs/*.jar', fingerprint: true)
      }
    }

    stage('Deploy') {
      parallel {
        stage('Deploy') {
          steps {
            sh 'ls build/libs/*.jar'
            sh './gradlew test'
            echo 'Deploying...'
          }
        }

        stage('Docker') {
          steps {
            sh 'docker ps -a'
            sh 'docker build -t discovery-service .'
            sh 'docker run -p  8761:8761 --name discovery-service -t -d discovery-service'
          }
        }

      }
    }

    stage('Final Step') {
      steps {

        sh 'echo "Some crap goes here"'
        sh 'docker stop discovery-service'
        sh 'docker rm discovery-service'
      }
    }

  }
  triggers {
    pollSCM('* * * * *')
  }
}