FROM openjdk:17
ENV APP_HOME=/apps
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
WORKDIR $APP_HOME
COPY ./poetry-0.0.1-SNAPSHOT.jar ./poetry.jar
EXPOSE 8081
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-jar"]
CMD ["poetry.jar"]