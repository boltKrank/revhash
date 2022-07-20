cp .\build\libs\revhash-0.0.1-SNAPSHOT.war .\Revhash.war

docker build -t revhash .

docker run -it --rm -p 8888:8080 revhash

docker ps