// This example uses Jenkin's "declarative" syntax

pipeline {
  agent {
    kubernetes {
      // Define the pod template directly within the kubernetes agent
      containerTemplate {
        name 'gradle'
        image 'gradle'
        command 'sleep'
        args '30d'
      }
      podRetention onFailure()
    }
  }

  stages {
    stage('Checkout code and prepare environment') {
      steps {
        git url: 'https://github.com/Mmchich24/Continuous-Delivery-with-Docker-and-Jenkins-Second-Edition.git', branch: 'master'
        sh """
          cd Chapter08/sample1
          chmod +x gradlew
        """
      }
    }

    stage('Run tests and generate reports') {
      when {
          // Only deploy on the main branch
          branch 'main'
      }
      steps {      
        sh """
          cd Chapter08/sample1
          ./gradlew test
          ./gradlew jacocoTestReport
        """
        
      }
    }
    
    stage('Configure Git') {
      steps {
          script {
              // Add the workspace directory to Git's safe.directory configuration
              sh "git config --global --add safe.directory /home/jenkins/agent/workspace/ex6_master"
          }
      }
    }

    stage('Get the output of pull requests') {
      steps {
        script {
            // Checkout the master branch
            sh 'git pull origin master'
            sh 'git config pull.rebase false'
            // Checkout branch1
        }
      }
    }
    
    stage('Checkout code and prepare environment branch1') {
      steps {
        git url: 'https://github.com/Mmchich24/Continuous-Delivery-with-Docker-and-Jenkins-Second-Edition.git', branch: 'branch1'
        sh """
          cd Chapter08/sample1
          chmod +x gradlew
        """
      }
    }

    stage('Get the output of pull requests branch1') {
      steps {
        script {
            
            // Checkout branch1
            sh 'git config pull.rebase false'
            sh 'git pull origin branch1'
        }
      }
    }

    
  }
}
