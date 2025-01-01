pipeline {
    agent any

    environment {
        MAVEN_PATH = 'C:\\Users\\Yashu Kun\\Downloads\\apache-maven-3.9.9-bin\\apache-maven-3.9.9\\bin'
        SONAR_TOKEN = credentials('sonarqube-credentials')
        PATH = "${PATH};C:\\Windows\\System32;${MAVEN_PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                bat '''
                set PATH=%MAVEN_PATH%;%PATH%
                mvn clean install
                '''
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat '''
                set PATH=%MAVEN_PATH%;%PATH%
                mvn test
                '''
            }
        }

        stage('Check JaCoCo Report') {
            steps {
                echo 'Checking JaCoCo report...'
                bat 'if exist target\\jacoco.exec echo JaCoCo report found.'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Running SonarQube analysis...'
                bat '''
                set PATH=%MAVEN_PATH%;%PATH%
                mvn sonar:sonar -Dsonar.login=%SONAR_TOKEN%
                '''
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check logs for details.'
        }
    }
}
