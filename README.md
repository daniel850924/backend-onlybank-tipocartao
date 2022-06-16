# Backend Only Bank Tipo de Cartao

Esta aplicação possui o serviço de Tipo de Cartao:
Base de dados: AWS RDS Postgres

--build

docker buildx build --platform=linux/amd64 --build-arg JAR_FILE=backend-onlybank-tipocartao-1.0.0-SNAPSHOT.jar -t sdm/backend-onlybank-tipocartao .

--run

docker run -it -p 8082:8080 --name backend-onlybank-tipocartao -e APP_PORT=5432 -e APP_HOST=HOST -e APP_DB=DB -e APP_USERNAME=USER -e APP_PASSWORD=PASSWORD sdm/backend-onlybank-tipocartao
