FROM gradle:jdk11
WORKDIR /application
COPY [".gradle", "build.gradle", "settings.gradle", "gradle", "./"]
COPY src ./src
RUN gradle clean build --exclude-task test \
            --build-file=./build.gradle --settings-file=./settings.gradle