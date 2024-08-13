FROM hub.atomgit.com/amd64/openjdk:21

COPY *.jar /app.jar

CMD ["--server.port=8080"]

# 暴露应用运行的端口
EXPOSE 8080

# 指定容器启动时执行的命令
ENTRYPOINT ["java", "-jar", "/app.jar"]


