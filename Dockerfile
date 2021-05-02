# There is NO way to pass ENV variables from one docker build stage to anohter.
# However, you can specify ARG parameter on each stage, and variable to ARG will
# be assigned from --build-arg. Example: https://stackoverflow.com/questions/53541362/persist-env-in-multi-stage-docker-build
#Omit all unnecessary stuf and pass only jar itslef

#Build jar stage
FROM gradle:jdk11 AS build-jar-stage
WORKDIR /application
COPY [".gradle", "build.gradle", "settings.gradle", "gradle", "./"]
COPY src ./src
RUN gradle clean build --exclude-task test \
            --build-file=./build.gradle --settings-file=./settings.gradle

#Final Stage
FROM openjdk:11.0.8-jre-slim
WORKDIR /application
ARG IMAGE_VERSION
ENV IMG_VER ${IMAGE_VERSION}
COPY --from=build-jar-stage /application/build/libs/transactions-management-support-${IMAGE_VERSION}.jar ./


CMD java -jar /application/build/libs/transactions-management-support-${IMG_VER}.jar
