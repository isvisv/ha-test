# ha-test
Test work

## Pre-requisites

    MariaDB 10.1.17
    Maven 3.3.9
    
## Configuration

    ./pom.xml
    
        `mariadb-host`     - Address for MariaDB server
        `mariadb-port`     - Port for MariaDB server
        `mariadb-db`       - Database name
        `mariadb-username` - Username for authenticating to database server
        `mariadb-password` - Password for authenticating to database
        
    ./src/main/resources/META-INF/persistence.xml
    
        `hibernate.connection.url`      - JDBC connection URL for target datagase
        `hibernate.connection.username` - Username for authenticating to database server
        `hibernate.connection.password` - Password for authenticating to database
        
## Set-up instructions

1. To setup DB schema and sample data:
   
   `mvn liquibase:update`

2. To build the WAR archive for deployment to standalone server:
   
   `mvn clean package`
   
3. To launch application on Jetty web server:
   
   `mvn jetty:run`
   
    
