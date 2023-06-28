call(String project, String ImageTag, String hubUser){
    withCredentials([string(
        credentialsId: 'dockerhubpwd', 
        variable: 'dockehubpwd'
        )]) {
           sh "docker login -u '$dockerhubpwd' -p '$dockerhubpwd'"
        }
        sh "docker image push ${hubUser}/${project}:${ImageTag}"
        sh "docker image push ${hubUser}/${project}:latest"

}