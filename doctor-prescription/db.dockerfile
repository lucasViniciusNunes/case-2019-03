# Base Image
FROM microsoft/mssql-server-linux:latest

VOLUME ./sqldata:/var/lib/sqldata

RUN apt-get -y update

RUN DEBIAN_FRONTEND=noninteractive ACCEPT_EULA=Y apt-get -y install mssql-tools

RUN apt -y install ufw

# Create database.
CMD ["/opt/mssql-tools/bin/sqlcmd", "-S", "localhost", "-U", "SA", "-P", "ZYc32,?#N~kWCrqAWS", "-Q", "CREATE DATABASE medicine"]

EXPOSE 1433