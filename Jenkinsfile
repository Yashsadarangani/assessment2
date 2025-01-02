pipeline {
    agent any

    tools {
        maven 'sonarmaven'
    }

    environment {
        PATH = "${PATH};C:\\Windows\\System32;C:\\Users\\Yashu Kun\\Downloads\\apache-maven-3.9.9-bin\\apache-maven-3.9.9\\bin"
        SONAR_TOKEN = credentials('s')
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from SCM...'
                checkout scm
            }
        }

        stage('Clean target folder') {
            steps {
                echo 'Cleaning target directory...'
                bat 'mvn clean'
            }
        }

        stage('Build and Test') {
            steps {
                echo 'Building project and running tests...'
                bat 'mvn clean verify -DskipTests=false'
            }
        }

        stage('Validate JaCoCo Report') {
            steps {
                echo 'Validating JaCoCo coverage report...'
                bat '''
                if exist target\\site\\jacoco\\jacoco.xml (
                  echo "JaCoCo XML Report successfully generated."
                ) else (
                  echo "Error: JaCoCo XML Report not found."
                  exit 1
                )
                '''
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Running SonarQube analysis...'
                bat '''
                mvn sonar:sonar ^
                  -Dsonar.projectKey=assessment2 ^
                  -Dsonar.sources=src/main/java ^
                  -Dsonar.tests=src/test/java ^
                  -Dsonar.java.binaries=target/classes ^
                  -Dsonar.host.url=http://localhost:9000 ^
                  -Dsonar.token=%SONAR_TOKEN% ^
                  -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
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
