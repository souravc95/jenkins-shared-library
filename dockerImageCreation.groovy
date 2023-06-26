// vars/dockerImageCreation.groovy

def call(String imageName, String imageTag) {
    pipeline {
        agent any

        stages {
            stage('Build') {
                steps {
                    script {
                        def dockerImage = docker.build("${rabi4450/test-app}:${imagetag}")
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
