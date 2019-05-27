# �rbol binario
Versi�n inicial de servicio RESTFul encargado de crear �rboles binarios a partir de una lista de nodos y calcular el ancestro com�n m�s cercano entre dos nodos de un �rbol.

## Prerrequisitos
Para iniciar la aplicaci�n y/o ejecutar las pruebas unitarias es necesario contar con un dispositivo con conexi�n a internet, que tenga instalado Java 1.8 y Maven.

## Configuraci�n
Al ser una aplicaci�n Spring Boot se pueden configurar los par�metros ubicados en el archivo application.properties ubicado en la carpeta config.

		BinaryTree/templates/config/application.properties

Para una configuraci�n r�pida solo es necesario validar que el puerto de la aplicaci�n (8443 - Valor configurado en la rama master) est� disponible en la maquina donde se va a iniciar el proyecto o correr los test. Si no se encuentra disponible es posible ajustar el puerto en la propiedad �server.port�.

## Iniciar el proyecto
Para iniciar la aplicaci�n Spring Boot o ejecutar las pruebas JUnit es necesario clonar el proyecto de la rama master.
Una vez clonado el servicio es posible preparar la aplicaci�n para iniciarla mediante el siguiente comando:

		mvn clean install �DskipTests

Para iniciar la aplicaci�n basta con ejecutar:

		java -jar target/BinaryTree-1.0-SNAPSHOT.jar

NOTA: Todos los comandos anteriormente mencionados deben ser ejecutados desde la ubicaci�n ra�z del proyecto clonado (/BinaryTree)

### Ejecutar pruebas
El proyecto cuenta con la clase TreeServiceTest la cual se encarga de crear un �rbol binario y probar el c�lculo de ancestros comunes.
Para ejecutar las pruebas es necesario confirmar que no se modific� el puerto de la aplicaci�n. Si este se modifico es necesario ajustar la URL de la clase TreeServiceTest String TREE_SERVICE_PATH con el puerto configurado.

Es posible realizar las pruebas ejecutando el siguiente comando:
	
		mvn test

