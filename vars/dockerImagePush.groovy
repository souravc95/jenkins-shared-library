// Dockerhub login & Push using docker Token Access//

//def call(String project, String ImageTag, String hubUser){

    // withCredentials([string(credentialsId: 'dockerhub', variable: 'dockerhub')]) {

    //        sh "docker login -u rabi4450 -p ${dockerhub}"
    // }  
    //   sh "docker image push ${hubUser}/${project}:${ImageTag}"
    //    sh "docker image push ${hubUser}/${project}:latest" 
//}

//Dockerhub login & Push Using docker username and password valiale//

// def call(String project, String ImageTag, String hubUser){    
//     withCredentials([usernamePassword(
//      credentialsId: 'dockerhubpwd', 
//      passwordVariable: 'PASS',
//      usernameVariable: 'USER'
//      )]) {
    
//      sh "docker login -u '$USER' -p '$PASS'"
    
// }

//       sh "docker image push ${hubUser}/${project}:${ImageTag}"
//       sh "docker image push ${hubUser}/${project}:latest"
    

// }


// ECR login & Push Image //

def call(String aws_account_id, String region, String ecr-repoName){

    sh """

    docker build -t ${ecr-repoName} .
    aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
    docker push ${ecr-repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr-repoName}:latest

    """
}