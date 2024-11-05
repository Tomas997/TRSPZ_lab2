FROM openjdk:17
RUN rm /etc/localtime && ln -fs /usr/share/zoneinfo/Europe/Kiev /etc/localtime
WORKDIR /app
COPY . /app
RUN chmod +x mvnw
EXPOSE 8080
ENTRYPOINT ["./mvnw", "spring-boot:run"]