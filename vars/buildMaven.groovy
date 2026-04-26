// vars/buildMaven.groovy
// Compile le projet Maven et lance les tests unitaires.

def call() {
    echo "🔨 [Shared Lib] Build Maven..."
    sh 'mvn clean package -B'
    echo "✅ Build Maven terminé"
}
