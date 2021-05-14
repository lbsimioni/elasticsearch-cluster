#!/usr/bin/env bash

echo 'CREATING DOCKER COMPOSE'

echo $PWD


mkdir -p elasticsearch/data
rm -rf docker-compose.yml;

envsubst < "template-docker-compose.yml" > "docker-compose.yml";

echo 'CREATED DOCKER COMPOSE'