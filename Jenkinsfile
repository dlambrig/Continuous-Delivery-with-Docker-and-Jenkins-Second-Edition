pipeline { 
    agent any  

    environment { 
        GIT_URL = 'https://github.com/Jasp3rGit/Continuous-Delivery-with-Docker-and-Jenkins-Second-Edition.git'
        GRADLE_USER_HOME = "${WORKSPACE}/.gradle-cache"
    }

    stages {
        stage('Setup Environment Variables') {
            steps {
                script {
                    env.BRANCH_NAME = env.BRANCH_NAME ?: 'master'  // Use master if not defined
                }
            }
        }
        stage('Checkout Code') { 
            steps {
                checkout([$class: 'GitSCM', branches: [[name: "*/${BRANCH_NAME}"]], 
                          userRemoteConfigs: [[url: GIT_URL, credentialsId: '8670000e-24ed-4979-bfcf-d8061ebcea73']]])
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
