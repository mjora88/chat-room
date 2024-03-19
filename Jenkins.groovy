pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/mjora88/chat-room.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Deploy') {
            steps {
                sh 'scp target/chat-room.jar "user@my-server":/path/to/deployment'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Cleanup') {
            steps {
                sh 'rm -rf target/'
            }
        }
    }

    post {
        always {
            cleanWs()
        }

        success {
            echo 'ChatRoom pipeline completed successfully!'
        }

        failure {
            echo 'ChatRoom pipeline failed!'
        }
    }
}