#INFOVIS PROJECT

##Requirements
* [Docker](https://www.docker.com/)
* [Docker Compose](https://www.docker.com/)

##Setup & run
To setup the databases follow the instruction [here](Polymovie/README.md).
To start the containers use the following command in the "Polymovie" folder.

    docker-compose up -d

The containers are listening on ports 27017, 7474, 7687, 5432, be certain to have no other services listening on those ports.

To run the project use:

    mvn spring-boot:run

To stop the containers use:

    docker-compose stop

##Authors
* Valerio Cetorelli
* Alessandro Fogli