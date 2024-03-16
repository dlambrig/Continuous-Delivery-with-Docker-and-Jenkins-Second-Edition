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

  environment {
    // Define the branch name as a variable
    BRANCH_NAME = 'branch1'
  }

  stages {
    stage('Checkout code and prepare environment') {
      steps {
        sh """
          cd /home/jenkins/agent/workspace/ex6_master
        """
        // Use the BRANCH_NAME variable for the branch
        git url: 'https://github.com/Mmchich24/Continuous-Delivery-with-Docker-and-Jenkins-Second-Edition', branch: "${env.BRANCH_NAME}"
        sh """
          cd Chapter08/sample1
          pwd
          chmod +x gradlew
        """
      }
    }

    stage('Run CodeCoverage test on main branch') {
      when {
        // Check if the branch is 'master'
        expression { env.BRANCH_NAME == 'master' }
      }
      steps {
        echo 'Running code coverage'
        script {
          dir('/home/jenkins/agent/workspace/ex6_master/Chapter08/sample1'){
              try {
                // Run tests
                sh 'pwd'
                sh 'cd /home/jenkins/agent/workspace/ex6_master/Chapter08/sample1'
                sh 'pwd'
                sh './gradlew test'
    
                // If tests pass, echo "tests pass!"
                echo 'Tests pass!'
              } catch (Exception e) {
                // If tests fail, echo "tests fail!"
                echo 'Tests fail!'
              } finally {
                // Generate Jacoco report regardless of test results
                sh './gradlew jacocoTestReport'
              }
          }
          
        }
      }
    }

    stage('Run other tests on non-main branches') {
      when {
        // Check if the branch is not 'master'
        expression { env.BRANCH_NAME != 'master' }
      }
      steps {
        echo 'Running other tests on non-main branch'
        sh """
          cd Chapter08/sample1
          pwd
          ./gradlew test
        """
      }
    }
    
  }
  post {
        always {
            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'Chapter08/sample1/build/reports/jacoco/test/html',
                reportFiles: 'index.html',
                reportName: 'JaCoCo Code Coverage Report',
                reportTitles: 'JaCoCo Code Coverage Report'
            ])
        }
    }
  
}
