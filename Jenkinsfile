pipeline { 
    agent any  

    environment { 
        GIT_URL = 'https://github.com/Jasp3rGit/Continuous-Delivery-with-Docker-and-Jenkins-Second-Edition.git'
        BRANCH_NAME = env.BRANCH_NAME ?: 'master'  // Use master if not defined
        GRADLE_USER_HOME = "${WORKSPACE}/.gradle-cache"
    }

    stages { 
        stage('Checkout Code') { 
            steps {
                cleanWs()
                checkout([$class: 'GitSCM', branches: [[name: "*/${BRANCH_NAME}"]], 
                          userRemoteConfigs: [[url: GIT_URL, credentialsId: 'your-credentials-id']]])
            } 
        } 

        stage('Run Tests') { 
            steps { 
                script {
                    sh """
                        cd Chapter08/sample1
                        ./gradlew test --project-cache-dir=${GRADLE_USER_HOME}
                    """
                }
            }
        }
    } 

    post {
        always {
            echo "Pipeline execution completed."
        }
    }
}
