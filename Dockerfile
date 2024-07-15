FROM openjdk:17
ENV APP_HOME=/apps
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
WORKDIR $APP_HOME
COPY ./dbb-blog-0.0.1-SNAPSHOT.jar ./dbb-blog.jar
EXPOSE 8081
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-jar"]
CMD ["dbb-blog.jar"]