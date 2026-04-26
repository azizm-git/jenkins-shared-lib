// vars/pushDocker.groovy
// Login sur Docker Hub avec credentials Jenkins, puis push de l'image
// Usage : pushDocker(name: '...', tag: '...', credentialsId: 'dockerhub-creds')

def call(Map config) {
    if (!config.name || !config.tag || !config.credentialsId) {
        error "pushDocker requiert 'name', 'tag' et 'credentialsId'"
    }
    echo "📤 [Shared Lib] Push Docker Hub : ${config.name}:${config.tag}"
    withCredentials([usernamePassword(
        credentialsId: config.credentialsId,
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS')]) {
        sh """
            echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
            docker push ${config.name}:${config.tag}
            docker push ${config.name}:latest
            docker logout
        """
    }
    echo "✅ Image poussée sur Docker Hub"
}
