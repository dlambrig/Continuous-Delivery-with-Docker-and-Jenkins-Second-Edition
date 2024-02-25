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
        createPullRequest('master')
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
        // Create pull request for branch1
        createPullRequest('branch1')
      }
    }
    
  }
}

def createPullRequest(targetBranch) {
    // Use curl command to create pull request via GitHub API
    sh """
        curl -X POST \
             -H "Authorization: token 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" \
             -d '{"title":"Automated Pull Request", "head":"$(git rev-parse --abbrev-ref HEAD)", "base":"$targetBranch"}' \
             https://api.github.com/repos/Mmchich24/Continuous-Delivery-with-Docker-and-Jenkins-Second-Edition/pulls
    """
}
