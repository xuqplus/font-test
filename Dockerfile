FROM mayan31370/openjdk-alpine-with-chinese-timezone:8-jre

EXPOSE 8080
RUN apk --no-cache add fontconfig ttf-dejavu

COPY simkai.ttf simsun.ttc simsunb.ttf /usr/share/fonts/chinese/
ADD target/*.jar app.jar
