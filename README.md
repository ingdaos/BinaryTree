# Árbol binario
Versión inicial de servicio RESTFul encargado de crear árboles binarios a partir de una lista de nodos y calcular el ancestro común más cercano entre dos nodos de un árbol.

## Prerrequisitos
Para iniciar la aplicación y/o ejecutar las pruebas unitarias es necesario contar con un dispositivo con conexión a internet, que tenga instalado Java 1.8 y Maven.

## Configuración
Al ser una aplicación Spring Boot se pueden configurar los parámetros ubicados en el archivo application.properties ubicado en la carpeta config.

		BinaryTree/templates/config/application.properties

Para una configuración rápida solo es necesario validar que el puerto de la aplicación (8443 - Valor configurado en la rama master) esté disponible en la maquina donde se va a iniciar el proyecto o correr los test. Si no se encuentra disponible es posible ajustar el puerto en la propiedad “server.port”.

## Iniciar el proyecto
Para iniciar la aplicación Spring Boot o ejecutar las pruebas JUnit es necesario clonar el proyecto de la rama master.
Una vez clonado el servicio es posible preparar la aplicación para iniciarla mediante el siguiente comando:

		mvn clean install –DskipTests

Para iniciar la aplicación basta con ejecutar:

		java -jar target/BinaryTree-1.0-SNAPSHOT.jar

NOTA: Todos los comandos anteriormente mencionados deben ser ejecutados desde la ubicación raíz del proyecto clonado (/BinaryTree)

### Ejecutar pruebas
El proyecto cuenta con la clase TreeServiceTest la cual se encarga de crear un árbol binario y probar el cálculo de ancestros comunes.
Para ejecutar las pruebas es necesario confirmar que no se modificó el puerto de la aplicación. Si este se modifico es necesario ajustar la URL de la clase TreeServiceTest String TREE_SERVICE_PATH con el puerto configurado.

Es posible realizar las pruebas ejecutando el siguiente comando:
	
		mvn test

