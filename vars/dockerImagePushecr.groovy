def call ()

    withEnv ([ "AWS_ACCESS_KEY_ID=${env.AWS_ACCESS_KEY_ID}", "AWS_SECRET_ACCESS_KEY=${env.AWS_SECRET_ACCESS_KEY}", "AWS_DEFAULT_REGION=${env.AWS_DEFAULT_REGION}" ]) {

        sh  "docker login -u AWS -p $"
        sh   "docker tag myecr:latest 927552331003.dkr.ecr.us-east-1.amazonaws.com/myecr:latest  "
        sh  "docker push 927552331003.dkr.ecr.us-east-1.amazonaws.com/myecr:latest "



    
  }