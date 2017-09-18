# INFOVIS PROJECT

## Description
This project was developed during the [Information Visualization Course](http://www.dia.uniroma3.it/~infovis/) at Roma Tre University.  
Our project allows the user to navigate different informations about movies and actors taken from [The Movie DB](https://www.themoviedb.org/) and saved in three different databases (MongoDB, Neo4j and PostgreSQL).  

## Requirements
* [Docker](https://www.docker.com/)
* [Docker Compose](https://docs.docker.com/compose/)

## Dependencies
For further information about this project's dependencies you can check the [pom.xml](pom.xml) file and the readme [here](src/main/resources/externalJars/README.md).

## Setup & run
To setup the databases follow the instruction [here](Polymovie/README.md).
To start the containers use the following command in the "Polymovie" folder.

    docker-compose up -d

The containers are listening on ports 27017, 7474, 7687, 5432, make shure to have no other services listening on those ports.

To run the project use:

    mvn spring-boot:run

The project is available at:

	localhost:8080

To stop all the containers use:

    docker-compose stop

## Authors
* Valerio Cetorelli (valerio_cetorelli@yahoo.it)
* Alessandro Fogli (ale.fog93@yahoo.it)