#!/usr/bin/env bash
source /etc/environment

docker-compose down

# Create Custom docker-compose.yml
./create-docker-compose.sh

# Start Docker Images
echo 'START DOCKER IMAGES'

# Improving available memory
# sudo sysctl -w vm.max_map_count=262144

docker-compose down
docker system prune -f
docker kill $(docker ps -q)
docker-compose up -d es01 es02 es03 kib

while ! docker-compose logs --tail=10 kib | grep --line-buffered 'Starting monitoring stats collection'; do
  echo 'WAITING SETUP-END...'
  sleep 5
done

echo ''
echo -e '\033[01;32mSTARTED DOCKER'
echo -e '\033[01;36mSOME LINKS UTILS:'
echo -e '\033[01;36mELASTICSEARCH MASTER NODE: http://173.101.101.101:9200'
echo -e '\033[01;36mKIBANA: http://173.101.101.104:5601'
echo -e '\033[01;36mKIBANA CONSOLE: http://173.101.101.104:5601/app/dev_tools#/console'
echo -e '\033[01;34mENJOY OUR ELASTICSEARCH CLUSTER'
