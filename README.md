# ELASTICSEARCH CLUSTER #

Projeto for Elasticsearch Cluster in Spring Boot

This project was developed for an academic work, and do 
not aim at the business rule, but aim the architecture

# DEPENDENCIES #

Lombok: `https://projectlombok.org/`.

# SETUP #

This project uses an Elasticsearch Cluster, to make
easier, we created a script to create a Cluster, and
configure a netword.

For run this script (start-me.sh), you'll need
Docker, Docker Compose and Bash terminal.

## STEPS TO RUN THE SCRIPT ##

1. Give permission for script's run. 
(chmod 755 start-me.sh) (chmod 755 create-docker-compose.sh)
2. Make sure you have the necessary memory allocated
for docker-compose, if you need improve the memory,
you can run sudo sysctl -w vm.max_map_count=262144.
3. Run the script start-me.sh (./start-me.sh)

# DOCUMENTATION #

We used swagger to documented the API,
Link: `http://localhost:8080/swagger-ui/`
