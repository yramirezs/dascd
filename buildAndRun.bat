@echo off
call mvn clean package
call docker build -t co.gov.dascd/dascd .
call docker rm -f dascd
call docker run -d -p 9080:9080 -p 9443:9443 --name dascd co.gov.dascd/dascd