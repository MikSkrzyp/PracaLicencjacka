pipeline {
    agent any
    stages {
        stage('Preparing Tests') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Executing Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Generating Testing Report') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk              : '',
                            properties       : [],
                            reportBuildPolicy: 'ALWAYS',
                            results          : [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}
