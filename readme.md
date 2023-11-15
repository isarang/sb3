

# compile native image
    mvn -Pnative native:compile

# compile normal java image
    mvn clean package && java -jar target/sb3-0.0.1-SNAPSHOT.jar
