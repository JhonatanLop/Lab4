start-db:
	sudo systemctl start postgresql

stop-db:
	sudo systemctl stop postgresql

run-app:
	trap 'make stop-db' EXIT; mvn spring-boot:run

start: start-db run-app

stop: stop-db