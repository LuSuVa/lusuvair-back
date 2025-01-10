pipeline {
  agent any
  tools {
    maven 'Maven 3.9.6'
  }  
  stages {
    stage ('checkout'){
      steps {
       git branch: 'main',
           url: 'https://github.com/LuSuVa/lusuvair-back'
      }  
    }
    stage ('Build') {
     steps {
       sh 'mvn clean package'
     }
    }
    stage('Test'){
     steps{
       echo("Lancement des test unitaire")
       sh 'mvn test'
     }
    }  
    stage('SonarQube Analysis') {
     steps {
       script {
        def mvnHome = tool 'Maven 3.9.6' //
        withSonarQubeEnv('SonarQ') {
        sh "${mvnHome}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=lusuvair-back -Dsonar.projectName='lusuvair-back'"
       }
      }
     }   
    } 
  }
}
