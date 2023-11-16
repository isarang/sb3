# Spring boot 3

### compile native image
    mvn -Pnative native:compile

### compile normal java image
    mvn clean package && java -jar target/sb3-service-0.0.1-SNAPSHOT.jar

### generate reachability metadata
    mvn clean package && java -agentlib:native-image-agent=config-output-dir=target/generated-reachability-metadata -jar target/sb3-service-0.0.1-SNAPSHOT.jar

### mysql
    docker run --env=MYSQL_ROOT_PASSWORD=password --env=MYSQL_ROOT_HOST=% --env=MYSQL_MAJOR=8.0 --env=MYSQL_VERSION=8.0.33-1.el8 --env=MYSQL_SHELL_VERSION=8.0.33-1.el8 --volume=/var/lib/mysql -p 3306:3306 --restart=no --runtime=runc -d mysql:latest