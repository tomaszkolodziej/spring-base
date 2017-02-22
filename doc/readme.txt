1. W katalogu TOMCAT_HOME/conf ustawic uzytkownikow (tomcat-users.xml).
2. Uruchomienienie TOMCAT_HOME/bin/catalina.bat start.
3. Zakonczenie TOMCAT_HOME/bin/catalina.bat stop.
4. Tomcat URL: localhost:8090
5. Przykładowe użycie: curl http://localhost:8090/api/core/profiles
6. Uruchomienie z lini poleceń: java -jar app.jar --spring.profiles.active=production/development
7. Autentykacja na profilu development: curl -i -H "Content-Type: application/json" -X POST -d '{"username":"serwis","password":"$2a$04$5IRRSf2NvgOFMb4e8jtoveraDcdJcv3T0k//RLVQz8nsPqc235h1e"}' http://localhost:8090/api/authenticate
8. BCrypt: https://www.dailycred.com/article/bcrypt-calculator
9. Uruchomienie z tokenem:
    curl -i -H "Content-Type: application/json" -H "X-Auth-Token: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzZXJ3aXMiLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE0NzcyMjI2NzE0MTUsImV4cCI6MTQ3NzgyNzQ3MX0.Z_jJpk8kMwP8kEM1n27iP_j13kzPKjSnCskumt7gB6iArRI-U7xdNenZbLyxe1_IdptaWjFXLeqTULC3us7y2A" -X GET http://localhost:8090/api/core/profiles
10. Autentykacja metoda JWT ze strony: https://github.com/brahalla/Cerberus
11. https://github.com/auth0/angular2-jwt
12. Przykladowy post: curl -X POST http://localhost:8090/api/test/sendMail
13. Skrzynka pocztowa:
	email: tolean.contact@gmail.com
	haslo: t0lean.c0ntact
	
