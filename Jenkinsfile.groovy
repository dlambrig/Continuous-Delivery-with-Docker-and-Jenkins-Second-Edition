pipeline {
    agent any
    
    stages {
        stage('prepare environment') {
            when {branch 'master'}
            steps {
                echo 'all branches'
                }
                }

        stage('Code Coverage') {
            when { branch 'master' }
            steps {
                sh """
                cd Chapter08/sample1
                ./gradlew codeCoverage
                ./gradlew test
                ./gradlew jacocoTestReport
                ./gradlew checkstyleTest
                """
                }
        }

        stage('Feature Tests') {
            when { branch pattern: '.*feature.*' }
            steps {
                sh """
                ./gradlew test
                ./gradlew jacocoTestReport
                ./gradlew checkstyleTest                
                """
            }
        }

        stage('Fail on Other Branches') {
            when {
                not {
                    anyOf {
                        branch 'master'
                        branch pattern: '.*feature.*'
                    }
                }
            }
            steps {
                error('Branch name does not match allowed patterns.')
            }
        }
    }
}
