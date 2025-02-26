pipeline { 
    agent any

    environment { 
        GIT_URL = 'https://github.com/Jasp3rGit/Continuous-Delivery-with-Docker-and-Jenkins-Second-Edition.git'
    }

    stages { 
        stage('Checkout code and prepare environment') { 
            steps {
                cleanWs()
                git url: env.GIT_URL, branch: env.BRANCH_NAME
                sh """
                    docker --version

                    sudo usermod -aG docker jenkins

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
                            ./gradlew test 
                            ./gradlew jacocoTestReport 
                        """
                    } else if (env.BRANCH_NAME.contains('feature')) { 
                        echo "Running all tests except CodeCoverage on feature branch."
                        sh """ 
                            cd Chapter08/sample1
                            ./gradlew test
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
                    ./gradlew build 
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
}
