//  Image clanup for Docker //

// def call(String project, String ImageTag, String hubUser){
     
//      sh """
       
//        docker rmi ${hubUser}/${project}:${ImageTag}
//        docker rmi ${hubUser}/${project}:latest

//      """

// }

//  Docker Image cleanup for

def call(String project, String ImageTag, String hubUser){
     
     sh """
       
       docker rmi ${ecr-repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr-repoName}:latest

     """

}