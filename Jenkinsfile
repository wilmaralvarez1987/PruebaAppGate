import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()
def CORREOS = "";

pipeline{
	agent { 
        node { 
            label 'VM_Test_Slave3' 
        }         
    }
	stages{
		stage('Obtener fuentes ') {
		 	steps{
		 		git url: 'https://vostpmde37.proteccion.com.co:10443/Tester_Choucair/pruebasAceptacionLaboratorioEmpresas.git'
			}
		}

		stage('Ejecutar Pruebas')
		{
			steps{
				script{
					try{
					 sh ("gradle clean test -DRunner=\"${Runner}\" aggregate") 
						echo 'Ha ejecutado sin fallo test junit'	
						currentBuild.result = 'SUCCESS'				
						 									
					}
					catch(ex)
					{   					
	    				echo 'Finalizo ejecucion de framework junit con fallos'
	    				currentBuild.result ='UNSTABLE'        						
      					
					}	
				}
			}	
		}
		stage('Generar Evidencias')
		{
			steps{
				script{	   
				
				     try{
							bat " rename \"${WORKSPACE}\\target\\site\\serenity\" serenity_${timestamp}"
		                    echo 'Backup de evidencias realizado con exito'
		                          
		                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}\\target\\site\\serenity_${timestamp}", reportFiles: 'index.html', reportName: 'Evidencias Pruebas Aceptacion', reportTitles: ''])
							echo 'Reporte Html realizado con exito'
						
						}
						catch(e)
						{    
							echo 'No se realizó el Backup de evidencias'			    				
			    			publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}\\target\\site\\serenity", reportFiles: 'index.html', reportName: 'Evidencias Pruebas Aceptacion', reportTitles: ''])
							echo 'Reporte Html realizado con exito'								
							currentBuild.result='UNSTABLE'
						}
				}
			}	
		}
		
		stage('Notificar')
		{
			steps{
				script{		 


						if (currentBuild.result == 'UNSTABLE')
         						currentBuild.result = 'FAILURE'
         						
         				if (currentBuild.result == 'SUCCESS')
         						emailext (
          					subject: " '${Runner}'- EJECUCION EXITOSA ESCENARIOS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
          					body: """<p><b style="color:MediumSeaGreen;">EJECUCION EXITOSA:</b> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
            					<p><b>Para verificar el estado de la ejecucion ingrese a:</b> &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
         					 to:"${CORREOS}"
        				)
        				if (currentBuild.result == 'FAILURE')	
        				emailext (
          					subject: "'${Runner}' - EJECUCION FALLIDA ESCENARIOS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
          					body: """<p><b style="color:red;">EJECUCION FALLIDA:</b> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
            					<p><b>Para verificar el estado de la ejecución ingrese a:</b> &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
         					 to:"${CORREOS}"
        				) 

				}
			}
				
		}	
		
		
		 
		
				
	}	
}