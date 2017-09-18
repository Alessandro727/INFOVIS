#!/bin/bash

wget https://www.dropbox.com/s/318zw9763rct51b/mongodb.tar.gz -O ./mongodb.tar.gz
wget https://www.dropbox.com/s/pqdd67qf5mbl59y/neo4j.tar.gz -O ./neo4j.tar.gz
wget https://www.dropbox.com/s/n1z3wb5l3va02nv/postgres.tar.gz -O ./postgres.tar.gz

echo 'Extracting mongodb.tar.gz'
tar -C ./db -xzf mongodb.tar.gz
echo 'Extracting neo4j.tar.gz'
tar -C ./db -xzf neo4j.tar.gz
echo 'Extracting postgres.tar.gz'
tar -C ./db -xzf postgres.tar.gz

echo

rm -v ./mongodb.tar.gz
rm -v ./neo4j.tar.gz
rm -v ./postgres.tar.gz
