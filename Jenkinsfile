pipeline {
	agent any

    triggers {
        pollSCM('* * * * *')
    }
	
	stages {
		stage('Build') {
			steps {
				git 'https://github.com/roseruby143/TravelManagement-webservice.git'
				
				sh './mvnw compile'
				
				echo '----------------- Building the project -----------------'
			}
		}
		
		stage('Maven Package Building') {
			steps {
				sh './mvnw package'
			
				echo '----------------- Packaging the project -----------------'
			}
		}
		
		stage('Docker Build Image') {
			steps {
				echo '----------------- This is a build docker image phase ----------'
                sh '''
                     sudo docker build -t tms-webservice-app .
                '''
			}
		}
		
		stage('Docker Deploy') {
			steps {
				echo '----------------- This is a docker deployment phase ----------'
                sh '''
                	(if  [ $(sudo docker ps -a | grep tms-webservice-app-container | cut -d " " -f1) ]; then \
	                        echo $(sudo docker rm -f tms-webservice-app-container); \
	                        echo "---------------- successfully tms-webservice-app-container ----------------"
	                     else \
	                    echo OK; \
	                 fi;);
            		sudo docker run --network=mysql-network -p 9070:9070 --name tms-webservice-app-container -d tms-webservice-app
            	'''
			}
		}
	}
}
