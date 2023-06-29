def call(String project, String ImageTag, String hubUser){

    // withCredentials([string(credentialsId: 'dockerhub', variable: 'dockerhub')]) {

    //        sh "docker login -u rabi4450 -p ${dockerhub}"

    // }  
    withCredentials([usernamePassword(
     credentialsId: 'dockerhubpwd', 
     passwordVariable: 'PASS',
     usernameVariable: 'USER'
     )]) {
    
     sh "docker login -u '$USER' -p '$PASS'"
    
}

      sh "docker image push ${hubUser}/${project}:${ImageTag}"
      sh "docker image push ${hubUser}/${project}:latest"
    

}