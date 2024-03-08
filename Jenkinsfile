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
        sleep 100 
        git url: 'https://github.com/Mmchich24/Continuous-Delivery-with-Docker-and-Jenkins-Second-Edition.git', branch: 'master', credentialsId: 'f697106a-e8ae-4221-b43c-feb366d19012'
        sleep 300
        sh """
          cd Chapter08/sample1
          chmod +x gradlew
        """
      }
    }
  }
}
