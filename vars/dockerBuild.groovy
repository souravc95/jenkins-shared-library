// Docker Image build for DockerHUB

// def call(String project, String ImageTag, String hubUser){
     
//      sh """
//        docker build -t ${hubUser}/${project} .
//        docker image tag ${hubUser}/${project} ${hubUser}/${project}:${ImageTag}
//        docker image tag ${hubUser}/${project} ${hubUser}/${project}:latest

//      """

// }


// Docker build for ECR REPO

 def call(String project, String ImageTag, String hubUser){

    

}