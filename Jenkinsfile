pipeline {
    agent any

    tools {
        maven 'sonarmaven'
    }

    environment {
        PATH = "${PATH};C:\\Windows\\System32"
        MAVEN_PATH = 'C:\\Users\\Yashu Kun\\Downloads\\apache-maven-3.9.9-bin\\apache-maven-3.9.9\\bin'
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
                bat '''
                mvn clean install
                set PATH=%MAVEN_PATH%;%PATH%
                mvn clean
                '''
            }
        }

        stage('Test') {
            steps {
                echo 'Testing the project...'
                bat '''
                set PATH=%MAVEN_PATH%;%PATH%
                mvn test
                '''
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the compiled code...'
                bat '''
                set PATH=%MAVEN_PATH%;%PATH%
                mvn package
                '''
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Running SonarQube analysis...'
                bat '''
                set PATH=%MAVEN_PATH%;%PATH%
                mvn sonar:sonar ^
                  -Dsonar.projectKey=assessment2 ^
                  -Dsonar.sources=src/main/java ^
                  -Dsonar.tests=src/test/java ^
                  -Dsonar.java.binaries=target/classes ^
                  -Dsonar.host.url=http://localhost:9000 ^
                  -Dsonar.token=sqa_e0d66921a5e37d4859d748d025d4fe0c23afcbc7 ^
                  -Dsonar.duplications.hashtable=200000 ^
                  -Dsonar.jacoco.reportPath=target/jacoco.exec ^
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
