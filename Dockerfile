#
#Первый вариант
#
FROM openjdk:17

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run","-DskipTests"]
#
#Второй вариант
#
#FROM openjdk:18

#WORKDIR /app

#EXPOSE 8081
#ADD /target/*.jar ./lab.jar
#ENTRYPOINT ["java","-jar","./lab.jar"]