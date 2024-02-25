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
        // Create pull request for
        
      }
    }

      stage('Get the output of pull requests') {
      steps {
        // Create pull request for master branch
        git checkout -b master
        git pull origin master
        // Create pull request for master branch
        git checkout -b branch1
        git pull origin branch1
        
        
      }
    }
    
  }
}

