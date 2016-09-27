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
        
## Set-up instructions

#### Database

1. Create database tables and insert sample data. The target database will be created if it does not exist yet.
   
   `mvn liquibase:update`
   
   
    
