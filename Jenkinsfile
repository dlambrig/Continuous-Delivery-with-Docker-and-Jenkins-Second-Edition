pipeline { 
    agent any 
    

    triggers { 
        pollSCM('H/5 * * * *') // Polls GitHub every 5 minutes
    }

    environment { 
        GIT_URL = 'https://github.com/Jasp3rGit/Continuous-Delivery-with-Docker-and-Jenkins-Second-Edition.git'
        BRANCH_NAME = 'master'
    }

    stages { 
        stage('Checkout code and prepare environment') { 
            steps {
                cleanWs()
                git url: env.GIT_URL, branch: env.BRANCH_NAME
                sh """ 
                    cd Chapter08/sample1 
                    chmod +x gradlew 
                """
            } 
        } 

        stage('Run tests and generate reports') { 
            steps { 
                sh """ 
                    cd Chapter08/sample1
                    ./gradlew test 
                    ./gradlew jacocoTestReport 
                """ 
                publishHTML ( 
                    target: [ 
                        reportDir: 'Chapter08/sample1/build/reports/tests/test', 
                        reportFiles: 'index.html', 
                        reportName: "JaCoCo Report" 
                    ]
                )
            } 
        }

        stage("Check for Java file modifications") {
            steps {
                script {
                    def javaFilesChanged = sh(script: "git diff --name-only HEAD~1 | grep '\\.java' | wc -l", returnStdout: true).trim()
                    env.JAVA_MODIFIED = (javaFilesChanged.toInteger() > 0) ? "true" : "false"
                }
            }
        }

        stage("Run CodeCoverage & Checkstyle if needed") {
            when { 
                expression { env.JAVA_MODIFIED == "true" } // Runs only if Java files were modified
            }
            steps {
                sh """ 
                    cd Chapter08/sample1
                    ./gradlew jacocoTestCoverageVerification
                    ./gradlew checkstyleMain --stacktrace
                """ 
                publishHTML ( 
                    target: [ 
                        reportDir: 'Chapter08/sample1/build/reports/checkstyle', 
                        reportFiles: 'main.html', 
                        reportName: "JaCoCo Checkstyle Report" 
                    ]
                )
            }
        }

        stage("Pipeline Status") {
            steps {
                script {
                    def status = currentBuild.result ?: 'SUCCESS'
                    if (status == 'SUCCESS') {
                        echo "pipeline ran perfectly"
                    } else {
                        echo "pipeline failure"
                    }
                }
            }
        }
    } 
}
