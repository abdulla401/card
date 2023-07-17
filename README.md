# Card
Spring boot REST api with jpa(h2), security(token) and tests

## Build and run tests
Run: ./gradlew bootRun
Test: ./gradlew test
We need to provide a X-API-KEY: <<secret is in codebase, security folder>> as a header

## AWS Account
Create a AWS account
Install CLI
Create access key and login into CLI

## Docker
./gradlew build

docker build -t abdulla401/card:latest .
docker image ls
docker login
docker push abdulla401/card:latest
docker run -e AWS_REGION='eu-west-2' -e AWS_ACCESS_KEY_ID='xxx' -e AWS_SECRET_ACCESS_KEY='xxx' -p 9000:8080 abdulla401/card
