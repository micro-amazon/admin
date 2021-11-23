pipeline {
  agent {
      kubernetes {
        yaml '''
          apiVersion: v1
          kind: Pod
          spec:
            containers:
            - name: docker
              image: docker:1.11
              command: ['cat']
              tty: true
              volumeMounts:
              - name: dockersock
                mountPath: /var/run/docker.sock
            volumes:
            - name: dockersock
              hostPath:
                path: /var/run/docker.sock
        '''
      }
    }
  stages {
    stage('git scm update') {
      steps {
        container('docker') {
          git url: 'https://github.com/micro-amazon/admin.git', branch: 'main'
        }
      }
    }
    stage('docker build and push') {
      steps {
        container('docker') {
          withCredentials([usernamePassword(
                    credentialsId: 'docker_hub_auth',
                    usernameVariable: 'USERNAME',
                    passwordVariable: 'PASSWORD')])
          sh '''
          docker build -t zwan2/mini-amazon-admin .
          docker push zwan2/mini-amazon-admin
          '''
          
        }
      }
    }
    stage('deploy kubernetes') {
      steps {
        sh '''
        kubectl create deployment admin-prod --image=zwan2/mini-amazon-admin:admin
        kubectl expose deployment admin-prod --type=LoadBalancer --port=8080 \
                                               --target-port=80 --name=pl-admin-prod-svc
        '''
      }
    }
  }
}