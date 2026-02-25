# 阶段 1: Builder
FROM eclipse-temurin:21-jre-alpine AS builder
WORKDIR /app
COPY target/*.jar app.jar
# Spring Boot 3.3+ 使用 tools jarmode
RUN java -Djarmode=tools -jar app.jar extract --layers --destination extracted

# 阶段 2: Final
FROM eclipse-temurin:21-jre-alpine AS final
WORKDIR /app

# 按顺序复制所有层到同一个目录
COPY --from=builder /app/extracted/dependencies/ ./
COPY --from=builder /app/extracted/spring-boot-loader/ ./
COPY --from=builder /app/extracted/snapshot-dependencies/ ./
COPY --from=builder /app/extracted/application/ ./

# Spring Boot 3.3+ 不再直接调用 JarLauncher，而是使用 java -jar 运行轻量级瘦 Jar
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-jar", "app.jar"]