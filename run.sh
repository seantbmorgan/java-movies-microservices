#!/bin/bash

java -jar ./movie-catalog-service/target/movie-catalog-service-0.0.1-SNAPSHOT.jar &
java -jar ./movie-discovery-server/target/movie-discovery-server-0.0.1-SNAPSHOT.jar &
java -jar ./movie-info-service/target/movie-info-service-0.0.1-SNAPSHOT.jar &
java -jar ./movie-ratings-data-service/target/movie-ratings-data-service-0.0.1-SNAPSHOT.jar 