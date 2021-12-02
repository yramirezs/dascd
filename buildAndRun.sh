#!/bin/sh
mvn clean package && docker build -t co.gov.dascd/dascd .
docker rm -f dascd || true && docker run -d -p 9080:9080 -p 9443:9443 --name dascd co.gov.dascd/dascd