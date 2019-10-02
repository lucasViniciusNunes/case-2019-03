## Vitta test

#### Inciando a API.

No diretório doctor-prescription compile o projeto com o comando:

``` mvn clean install ```

Acesse o diretório doctor-prescription/db do projeto, onde encontra-se os arquivos do docker, e execute o comando a seguir:

``` docker-compose up --build ```

Assim que o container do banco de dados estiver em execução, crie o banco de dados com o comando abaixo:

``` docker exec -it sqlserver1 /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P ZYc32,?#N~kWCrqAWS -Q 'CREATE DATABASE medicine' ```

Em seguida, acesse o diretório doctor-prescription e execute o comando para subir o container da aplicação:

``` docker-compose up --build ```

### Test

O diretório docs possui uma collection do postman com as chamadas dos serviços disponíveis na API.

Adicionei apenas alguns medicamento para os teste: 40812, 21058 - 28438, 10508 - 26028, 25171