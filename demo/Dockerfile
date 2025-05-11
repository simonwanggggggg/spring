# 使用 OpenJDK 17 作為基礎映像
FROM openjdk:17-jdk-slim

# 指定 jar 路徑（與 mvn package 打包出來一致）
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar

# 複製 jar 到容器中
COPY ${JAR_FILE} app.jar

# 暴露 8080 port
EXPOSE 8080

# 啟動 Spring Boot 應用
ENTRYPOINT ["java", "-jar", "/app.jar"]