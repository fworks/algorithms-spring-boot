ls .
/etc/filebeat/filebeat -e -c /etc/filebeat/filebeat.yml &
java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -Xmx256m -jar /app.jar
