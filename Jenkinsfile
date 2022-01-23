@Library('jenkins-shared-library')_

pipeline {

    agent any

    environment {
        NEXUS_REPO = "107.22.111.48:8083"
        TAG = "1.0"
        IMAGE = "${NEXUS_REPO}/java-maven-app:${TAG}"
    }
    tools {
        maven "maven-latest"
    }

    stages {

        stage("build") {
            steps {
                script {
                    echo "testing and packaging the application..."
                    testAndPackage()
                }
            }
        }

        stage("buildImage") {
            steps {
                script {
                    echo "building image $IMAGE...now"
                    buildImage(IMAGE, NEXUS_REPO)
                    echo "image $IMAGE built"
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