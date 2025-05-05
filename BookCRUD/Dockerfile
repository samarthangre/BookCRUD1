FROM maven:3.8.1-openjdk-17 as Build
COPY . .
RUN mvn package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=Build /target/BookCRUD-0.0.1-SNAPSHOT.jar BookCRUD.jar
EXPOSE 8089
ENTRYPOINT [ "java","-jar","BookCRUD.jar"]

