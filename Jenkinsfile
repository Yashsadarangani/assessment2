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

        stage('Checkstyle Validation') {
            steps {
                script {
                    try {
                        bat 'mvn checkstyle:check'
                    } catch (Exception e) {
                        echo "Checkstyle found violations, but pipeline will continue."
                    }
                }
            }
        }

        stage('Validate JaCoCo Report') {
            steps {
                echo 'Validating JaCoCo XML Report...'
                bat '''
                if exist target\\site\\jacoco\\jacoco.xml (
                    echo "JaCoCo XML Report successfully validated."
                ) else (
                    echo "Error: JaCoCo XML Report not found in target/site/jacoco/jacoco.xml."
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
                  -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml ^ 
                  -Dsonar.duplications.hashtable=200000 ^ 
                  -Dsonar.duplications=always
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
