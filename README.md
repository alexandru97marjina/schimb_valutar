# schimb_valutar Orange

##Reguli pentru pornirea Aplicatiei :

#1. Schimbarea datelor de conectare la baza de date
spring.datasource.url=jdbc:mysql://localhost:3306/schimb_valutar?useSSL=false&serverTimezone=EET
spring.datasource.username=root
spring.datasource.password=secret

#2. Pornirea bazei de date local
#3. Crearea unei baze date cu numele schimb_valutar
#4. Rularea ./gradlew bootRun

Tabele users si currency_dictionaries **se vor importa prin flyway** in proiect la pornirea acestuia iar restul tabelelor vor fi create de modele

Iar pentru testarea functionalului importati in Postman fisierul **Orange_Schimb_Valutar.postman_collection.json**
