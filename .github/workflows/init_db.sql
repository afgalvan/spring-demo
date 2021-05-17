CREATE USER 'springroot'@'localhost' IDENTIFIED BY 'springroot';

GRANT USAGE ON *.* TO 'springroot'@'springroot';

CREATE DATABASE IF NOT EXISTS 'tasks';

GRANT ALL PRIVILEGES ON 'tasks'.* TO 'springroot'@'localhost' WITH GRANT OPTION;
