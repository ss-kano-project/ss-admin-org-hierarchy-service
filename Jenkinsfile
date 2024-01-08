node{
  def ARTIFACT_REGISTRY = "ss-global-org-service"
  def repourl = "${PROJECT_ID}.${REGISTRY_URL}/${ARTIFACT_REGISTRY}"
  def imageTag = "${env.BUILD_NUMBER}"
  def imageUrl = "${repourl}:${imageTag}"
  def mvnHome = tool name: 'maven', type: 'maven'
  def mvnCMD = "${mvnHome}/bin/mvn "
  def zone = "${ZONE}"
  stage('Checkout'){
    checkout([$class: 'GitSCM',
    branches:[[name:'*/main']],
    extension:[],
    userRemoteConfigs:[[credentialsId:'git',
    url:'https://github.com/ss-kano-project/ss-admin-org-hierarchy-service.git'
    ]]])
  }
  stage('Build and Push Image') {
        withCredentials([[$class: 'AmazonWebServicesCredentialsBinding',
                          credentialsId:"aws-secret-access-key",
                          accessKeyVariable: 'AWS_ACCESS_KEY_ID',
                          secretKeyVariable: 'AWS_SECRET_ACCESS_KEY'
        ]]){
          sh("aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin 780280600324.dkr.ecr.ap-south-1.amazonaws.com")
          sh("${mvnCMD} clean install jib:build -Dimage=${imageUrl}")
        }
    }
  stage('Deploy'){
  withCredentials([[$class: 'AmazonWebServicesCredentialsBinding',
                    credentialsId:"aws-secret-access-key",
                    accessKeyVariable: 'AWS_ACCESS_KEY_ID',
                    secretKeyVariable: 'AWS_SECRET_ACCESS_KEY'
  ]]){
    sh("aws eks --region ${zone} update-kubeconfig --name ${CLUSTER}")
    sh("sed -i 's|IMAGE_URL|${imageUrl}|g' k8s/deployment.yml")
    sh("kubectl apply -f k8s/deployment.yml")
  }
}

} 
