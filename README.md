# ha-test
Test work

## Pre-requisites

    WildFly 10.1.0
    MariaDB 10.1.17
    Maven 3.3.9
    
## Configuration

    ./pom.xml
    
        `mariadb-host`     - Address for MariaDB server
        `mariadb-port`     - Port for MariaDB server
        `mariadb-db`       - Database name
        `mariadb-username` - Username for authenticating to database server
        `mariadb-password` - Password for authenticating to database server
        
    ./ear/scr/main/resources/setup_ds.bat
        
        `WILDFLY_HOME`   - A path to installation directory for WildFly Server
        `CONNECTION_URL` - A JDBC-compliant URL for datasource
        `DB_USERNAME`    - Username for authenticating to database server
        `DB_PASSWORD`    - Password for authenticating to database server
        
## Set-up instructions

1. Setup DB schema and sample data:
   
   `mvn liquibase:update -Pdb`

2. Add datasource to WildFly Server configuration:
   
   `cd ear/src/main/resources`
   
   `setup_ds.bat`
   
3. Build the EAR archive for deployment to WildFly Server:
   
   `mvn clean install`
   
4. Deploy EAR file to WildFly Server:
   
   `mvn wildfly:deploy`
      
5. Access application at URL like `http://localhost:8080/haear/index.zul`   
    
