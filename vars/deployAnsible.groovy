// vars/deployAnsible.groovy
// Lance le playbook Ansible avec les variables host/image/env
// Usage : deployAnsible(host: '192.168.170.134', image: '...', env: 'staging')

def call(Map config) {
    if (!config.host || !config.image || !config.env) {
        error "deployAnsible requiert 'host', 'image' et 'env'"
    }
    echo "🚀 [Shared Lib] Déploiement ${config.env} sur ${config.host}"
    ansiblePlaybook(
        playbook:  'ansible/deploy.yml',
        inventory: 'ansible/hosts',
        extras:    "-e target_host=${config.host} -e image=${config.image} -e app_env=${config.env}"
    )
    echo "✅ Déploiement ${config.env} terminé"
}
