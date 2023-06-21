mvn clean install
java -jar target/spring-boot-security-jwt-0.0.1-SNAPSHOT.jar > log.txt &
MyPID=$!                        # You sign it's PID
echo $MyPID                     # You print to terminal
echo "kill $MyPID" > shutdown.sh
chmod 777 shutdown.sh
