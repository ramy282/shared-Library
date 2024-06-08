def call(String openshiftCredentialsID, String openshiftClusterURL, String openshiftProject, String imageName) {
    withCredentials([string(credentialsId: openshiftCredentialsID, variable: 'OPENSHIFT_TOKEN')]) {
        sh """
            oc login ${openshiftClusterURL} --token=${OPENSHIFT_TOKEN} --insecure-skip-tls-verify=true
            oc project ${openshiftProject}
            oc new-app ${imageName}
            oc expose svc/${imageName}
        """
    }
}
