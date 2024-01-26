CREATE
DATABASE aconso
WITH OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE USER aconso WITH PASSWORD 'secret';
GRANT CONNECT ON DATABASE aconso TO aconso;
GRANT ALL ON schema public TO aconso;

GRANT ALL PRIVILEGES ON DATABASE aconso TO aconso;