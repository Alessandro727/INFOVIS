# How to setup Docker Compose
To setup Docker Compose extract the content following tar.gz archives in the path Polymovie/db, next to the hidden file .gitkeep. 

* [MongoDB](https://www.dropbox.com/s/318zw9763rct51b/mongodb.tar.gz)
* [Neo4j](https://www.dropbox.com/s/pqdd67qf5mbl59y/neo4j.tar.gz)
* [PostgreSQL](https://www.dropbox.com/s/n1z3wb5l3va02nv/postgres.tar.gz)

At the end the Polymovie folder should look like this:

    Polymovie   
    ├── docker-compose.yml   
    ├── db  
    │   └── .gitkeep
    │   └── mongodb
    │       └── diagnostic.data    
    │       └── journal   
    │       └── ...   
    │   └── neo4j  
    |       └── databases   
    |       └── dbms    
    │   └── postgres
    |       └── base  
    |       └── global  
    |       └── ...      
    
### Download scriprt

We also provide a simple bash script (located in this folder) that will do all the work for you. 