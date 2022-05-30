def buildJar() {
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage() {
    echo 'building the docker image...'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USERNAME', passwordVariable: 'PWD')]) {
        sh "docker build -t jfarrow02/java-maven-app:0.2 ."
        sh "echo $PWD | docker login -u $USERNAME --password-stdin"
        sh "docker push jfarrow02/java-maven-app:0.2"
    }
}

def deployApp() {
    echo 'deploying the application...'
}