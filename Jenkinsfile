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
                checkout scm
            }
        }

        stage('Clean target folder') {
            steps {
                echo 'Cleaning target directory...'
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Testing the project...'
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the compiled code...'
                bat '''
                mvn package
                dir target  // Verify that jacoco.exec is generated here
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
                  -Dsonar.token=sqa_e0d66921a5e37d4859d748d025d4fe0c23afcbc7 ^
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
