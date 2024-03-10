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
        sh """
          cd /home/jenkins/agent/workspace/ex6_master
        """
        git url: 'https://github.com/Mmchich24/Continuous-Delivery-with-Docker-and-Jenkins-Second-Edition', branch: 'master'
        sh """
          cd Chapter08/sample1
          pwd
          chmod +x gradlew
        """
      }
    }

    stage('Run CodeCoverage test on main branch') {
      when {
          // Only deploy on the main branch
          branch 'master'
      }
      steps { 
        echo 'runing codecoverage'
        sh """
          cd Chapter08/sample1
          ./gradlew test
          ./gradlew jacocoTestReport
        """ 
      }
    }
    
   stage('Run other tests on non-main branches') {
            when {
                not { branch 'master' }
            }
            steps {
                echo 'Running other tests on non-main branch'
                sh """
                cd Chapter08/sample1
                ./gradlew test
                """
            }
        }
    
  }
   post {
        success {
            echo 'Tests pass!'
        }
        failure {
            echo 'Tests fail!'
        }
    }
}
