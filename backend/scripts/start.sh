#! /usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/find_port.sh

REPOSITORY=/home/ec2-user/app/zero_downtime_deployment

echo "> Build 파일 복사"
echo ">cp $REPOSITORY/zip/*.jar $REPOSITORY"

cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> 새 애플리케이션 배포"
JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo "> $JAR_NAME 에 실행권한 추가"

chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"

IDLE_PORT=$(find_idle_port)

echo "> $JAR_NAME 를 $IDLE_PORT 포트에서 실행합니다."

nohup java -jar \
        -Dspring.profiles.active=prod \
        -Dserver.port=$IDLE_PORT \
        $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &