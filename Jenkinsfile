pipeline {
    agent any
    tools {
        maven 'sonarmaven' // Ensure this matches the Maven tool name in Jenkins
    }
    environment {
        PATH = "${PATH};C:\\Windows\\System32" // Ensure this is necessary
        SONAR_TOKEN = credentials('sonarqube-credentials') // Replace with your actual credential ID
    }
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the repository...'
                checkout scm
            }
        }
        stage('Build') {
            steps {
                echo 'Building the project...'
                bat '''
                mvn clean package
                mvn clean install
                '''
            }
        }
        stage('SonarQube Analysis') {
            steps {
                echo 'Starting SonarQube analysis...'
                withSonarQubeEnv('sonarqube-server') { // Ensure 'sonarqube-server' is configured in Jenkins
                    bat """
                    mvn sonar:sonar ^
                        -Dsonar.projectKey=assessment2 ^
                        -Dsonar.sources=src/main/java ^
                        -Dsonar.host.url=http://localhost:9000 ^
                        -Dsonar.login=%SONAR_TOKEN%
                        -Dsonar.java.binaries=src/main/java
                    """
                }
            }
        }
    }
    post {
        success {
            echo 'Build Succeeded!'
        }
        failure {
            echo 'Build Failed'
        }
    }
}
