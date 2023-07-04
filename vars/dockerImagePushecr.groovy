def call ()

    withEnv ([ "AWS_ACCESS_KEY_ID=${env.AWS_ACCESS_KEY_ID}", "AWS_SECRET_ACCESS_KEY=${env.AWS_SECRET_ACCESS_KEY}", "AWS_DEFAULT_REGION=${env.AWS_DEFAULT_REGION}" ]) {

        sh  "docker login -u AWS -p $"
        sh   "docker tag myecr:latest 927552331003.dkr.ecr.us-east-1.amazonaws.com/myecr:latest  "
        sh  "docker push 927552331003.dkr.ecr.us-east-1.amazonaws.com/myecr:latest "



    
  }


   withCredentials([string(credentialsId: 'github', variable: 'GITHUB_TOKEN')]) {
                sh '''
                    git config user.email "rabiin4tech@gmail.com"
                    git config user.name "rabi gayen"
                    // BUILD_NUMBER=${BUILD_NUMBER}
                    sed -i -e "s/javaapp.*/javaapp:${params.ImageTag}/g"  deployment.yml
                    git add deployment.yaml
                    git commit -m "Update deployment image to version ${params.ImageTag}"
                    git push https://${GITHUB_TOKEN}@github.com/${GIT_USER_NAME}/${GIT_REPO_NAME} HEAD:main
                '''