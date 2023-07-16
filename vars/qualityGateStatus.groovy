def call(credentialsId){


waitForQualityGate abortPipeline: false, credentialsId: 'sonarqube'

}


// http://18.212.237.27:8080/sonarqube-webhook/
