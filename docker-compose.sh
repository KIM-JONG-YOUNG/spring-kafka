#!/bin/bash

create_network() {

    if [ -z "`docker network ls | grep kafka_net | awk '{print $1}'`" ]; then
        # 도커 네트워크 생성 
        docker network create kafka_net
    fi
}

start_docker() {

    # zookeeper, kafka-1, kafka-2, kafka-3 실행 
    docker-compose -f ./docker-compose.yml up -d

}

stop_docker() {

    # zookeeper, kafka-1, kafka-2, kafka-3 실행 
    docker-compose -f ./docker-compose.yml down

}

create_topic() {

    if [ -n "$1" ]
    then
        # 토픽 생성  
        docker exec zookeeper kafka-topics --create --if-not-exists --zookeeper zookeeper:2181 --partitions 1 --replication-factor 1 --topic $1
    else
        echo "topic name is empty!"
    fi

}

tail_logs() {

    # 로그 확인 
    docker-compose logs -f --tail=10 $1

}

 case $1 in
    'start')
        create_network
        start_docker
        ;;
    'stop')
        stop_docker
        ;;
    'logs')
        tail_logs $2
        ;;
    'topic')
        create_topic $2
        ;;
    *)
        echo "Command 'start' or 'stop' or 'logs' or 'topic'"
 esac

exit 0