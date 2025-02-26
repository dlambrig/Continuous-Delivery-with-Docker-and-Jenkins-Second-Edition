pipeline { 
    agent any  

    environment { 
        GIT_URL = 'https://github.com/Jasp3rGit/Continuous-Delivery-with-Docker-and-Jenkins-Second-Edition.git'
        GRADLE_USER_HOME = "${WORKSPACE}/.gradle-cache"  // Caching directory
    }

    stages { 
        stage('Checkout code and prepare environment') { 
            steps {
                
                git url: env.GIT_URL, branch: env.BRANCH_NAME
                sh """ 
                    cd Chapter08/sample1 
                    chmod +x gradlew 
                """
            } 
        } 

        stage('Run tests based on branch') { 
            steps { 
                script {
                    if (env.BRANCH_NAME == 'master') { 
                        echo "Running CodeCoverage on master branch."
                        sh """ 
                            cd Chapter08/sample1
                            ./gradlew test --project-cache-dir=${GRADLE_USER_HOME}
                            ./gradlew jacocoTestReport --project-cache-dir=${GRADLE_USER_HOME}
                        """
                    } else if (env.BRANCH_NAME.contains('feature')) { 
                        echo "Running all tests except CodeCoverage on feature branch."
                        sh """ 
                            cd Chapter08/sample1
                            ./gradlew test --project-cache-dir=${GRADLE_USER_HOME}
                        """
                    } else { 
                        error "Branch ${env.BRANCH_NAME} is not allowed. Pipeline failed."
                    }
                }
            }
        }

        stage('Gradle Cache Test') { 
            steps { 
                echo "Running Gradle build with caching enabled..."
                sh """ 
                    cd Chapter08/sample1
                    ./gradlew build --project-cache-dir=${GRADLE_USER_HOME}
                """
            }
        }

        stage("Pipeline Status") {
            steps {
                script {
                    def status = currentBuild.result ?: 'SUCCESS'
                    if (status == 'SUCCESS') {
                        echo "Pipeline ran successfully."
                    } else {
                        echo "Pipeline failed."
                    }
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
