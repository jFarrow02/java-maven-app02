pipeline {

    agent any
    tools {
        maven 'maven-3.8.5'
    }
    environment {
        NEXUS_REPO = '54.209.127.2'
        NEXUS_PORT = '8083'
    }
    stages {

        stage("build jar") {
            steps {
                script {
                    echo "building the application..."
                    sh 'mvn package'
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'nexus-creds', usernameVariable: 'USERNAME', passwordVariable: 'PWD')]) {
                        sh "docker build -t $NEXUS_REPO:$NEXUS_PORT/java-maven-app:1.0 ."
                        sh "echo $PWD docker login -u $USERNAME --password-stdin $NEXUS_PORT"
                        sh "docker push $NEXUS_REPO:$NEXUS_PORT/java-maven-app:1.0"
                    }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying the application..."
                }
            }
        }
    }
}