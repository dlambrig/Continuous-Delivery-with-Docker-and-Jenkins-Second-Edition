podTemplate(yaml: '''
       apiVersion: v1
       kind: Pod
       spec:
        containers:
        - name: centos
          image: centos
          command: 
          - sleep
          args:
          - 99d
          restartPolicy: Never
'''){
    node(POD_LABEL){
        stage('k8s'){
            git 'https://github.com/Fezalkhalifa/Continuous-Delivery-with-Docker-and-Jenkins-Second-Edition.git'
            container('centos'){
               stage('Starting Calculator') {
                    sh '''
                       pwd
                       cd Chapter08/sample1
                       curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
                       chmod +x ./kubectl
                       ./kubectl apply -f calculator.yaml -n staging
                       ./kubectl apply -f hazelcast.yaml  -n staging
                       
                    '''
                }
               stage('Testing Calculator') {
                    sh '''
                       cd Chapter08/sample1
                       test $(curl calculator-service.staging.svc.cluster.local:8080/sum?a=3\\&b=4) -eq 7 && echo 'pass' || 'fail'
                       test $(curl calculator-service.staging.svc.cluster.local:8080/div?a=64\\&b=8) -eq 8 && echo 'pass' || 'fail'
                      
                    '''
                }
              /* stage('Removing Calculator') {
                    sh '''
                       ./kubectl delete deployment hazelcast calculator-deployment -n staging
                       ./kubectl delete service hazelcast calculator-deployment -n staging
                    '''
                }*/
                
            }
        }
    }
    
}
