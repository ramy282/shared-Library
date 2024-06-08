def call(String dockerHubCredentialsID, String imageName) {
    withCredentials([usernamePassword(credentialsId: dockerHubCredentialsID, passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
        sh "echo ${DOCKERHUB_PASSWORD} | docker login -u ${DOCKERHUB_USERNAME} --password-stdin"
        sh "docker push ${imageName}"
    }
}
