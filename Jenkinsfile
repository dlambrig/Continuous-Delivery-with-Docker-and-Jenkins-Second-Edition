pipeline { 
    agent {
        docker {
            image 'dlambrig/gradle-agent:latest'
            args '-v gradle-cache:/home/jenkins/.gradle'
        }
    }
    stages { 
        stage('Check Environment') {
            steps {
                sh 'gradle -v'  // Verify Gradle works
            }
        }
        stage('Build Project') {
            steps {
                sh './gradlew build'
            }
        }
    }
}
