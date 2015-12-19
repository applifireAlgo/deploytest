




echo $PATH
DB_PATH=/tmp/applifire/db/DO52BHRQM7AGD4AIR579A/DCC285B1-223B-40AC-9841-6567A0110E26
MYSQL=/usr/bin
USER=testproj
PASSWORD=testproj
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'