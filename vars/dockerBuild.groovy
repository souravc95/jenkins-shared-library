// Docker Image build for DockerHUB

// def call(String project, String ImageTag, String hubUser){
     
//      sh """
//        docker build -t ${hubUser}/${project} .
//        docker image tag ${hubUser}/${project} ${hubUser}/${project}:${ImageTag}
//        docker image tag ${hubUser}/${project} ${hubUser}/${project}:latest

//      """

// }


// Docker build for ECR REPO

 def call(String aws_account_id, String region, String ecr-repoName){

    sh """

    docker build -t ${ecr-repoName} .

    docker tag ${ecr-repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr-repoName}:latest

    """
}