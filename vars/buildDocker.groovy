// vars/buildDocker.groovy
// Construit une image Docker avec un double tag (version + latest)
// Usage : buildDocker(name: 'azizmjd/fastshop-api', tag: 'develop-12')

def call(Map config) {
    if (!config.name || !config.tag) {
        error "buildDocker requiert 'name' et 'tag'"
    }
    echo "🐳 [Shared Lib] Build Docker : ${config.name}:${config.tag}"
    sh "docker build -t ${config.name}:${config.tag} ."
    sh "docker tag  ${config.name}:${config.tag} ${config.name}:latest"
    echo "✅ Image construite et taguée"
}
