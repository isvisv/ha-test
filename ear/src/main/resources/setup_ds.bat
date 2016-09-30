SET WILDFLY_HOME=D:\wildfly-10.1.0.Final
SET CLI=%WILDFLY_HOME%\bin\jboss-cli.bat
SET CONNECTION_URL=jdbc:mariadb://localhost:3306/ha_test
SET DB_USERNAME=root
SET DB_PASSWORD=password

SET NOPAUSE=true

call %CLI% --connect command="module add --name=org.mariadb.jdbc --resources=./mariadb-java-client-1.5.2.jar --dependencies=javax.api,javax.transaction.api" 

call %CLI% --connect command="/subsystem=datasources/jdbc-driver=mariadb:add(driver-name=mariadb,driver-module-name=org.mariadb.jdbc,driver-class-name=org.mariadb.jdbc.Driver" 

call %CLI% --connect command="data-source add --jndi-name=java:jboss/datasources/HATestDS --name=MariaDBPool --connection-url=%CONNECTION_URL% --driver-name=mariadb --user-name=%DB_USERNAME%  --password=%DB_PASSWORD%"
