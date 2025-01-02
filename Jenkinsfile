pipeline {
    agent any

    tools {
        maven 'sonarmaven' // You should have a Maven tool installed with this name in Jenkins
    }

    environment {
        JAVA_PATH = "C:\\Program Files\\Java\\jdk-17\\bin"
        MAVEN_HOME = "C:\\Users\\Yashu Kun\\Downloads\\apache-maven-3.9.9-bin\\apache-maven-3.9.9\\bin"
        SONAR_TOKEN = credentials('sonar-token') // Add your SonarQube token as a Jenkins credential
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
                bat 'mvn clean install -U' // Run Maven clean and install
            }
        }

        stage('SonarQube Analysis') {
            steps {
                bat """
                    mvn clean verify sonar:sonar \
                    -Dsonar.projectKey=assessment2 \
                    -Dsonar.projectName='automation' \
                    -Dsonar.host.url=http://localhost:9000 \
                    -Dsonar.token=${SONAR_TOKEN} \
                    -Dsonar.java.binaries=target/classes \
                    -Dsonar.sources=src/main/java \
                    -Dsonar.tests=src/test/java \
                    -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
                """
            }
        }
    }

    post {
        success {
            echo "Build and SonarQube analysis completed successfully."
        }

        failure {
            echo "Build or SonarQube analysis failed."
        }
    }
}
