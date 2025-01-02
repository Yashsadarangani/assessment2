pipeline {
    agent any
    tools {
        maven 'sonarmaven'
    }
    environment {
        JAVA_PATH = "C:\\Program Files\\Java\\jdk-17\\bin"
        MAVEN_HOME = "C:\\Users\\Yashu Kun\\Downloads\\apache-maven-3.9.9-bin\\apache-maven-3.9.9\\bin"
        SONAR_TOKEN = credentials('s')
        PATH = "${env.PATH};${JAVA_PATH};${MAVEN_HOME}\\bin;C:\\Windows\\System32"
    }
    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install -U'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                bat """
                   mvn clean verify sonar:sonar \
                  -Dsonar.projectKey=assessment2 \
                  -Dsonar.projectName='automation' \
                  -Dsonar.host.url=http://localhost:9000 \
                  -Dsonar.token=sqa_e0d66921a5e37d4859d748d025d4fe0c23afcbc7
                """
            }
        }
    }
    post {
        success {
            echo "Build SUCCESSFULLY"
        }
        failure {
            echo "Build Failed"
        }
    }
}
