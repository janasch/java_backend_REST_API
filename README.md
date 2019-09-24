README
======

[Requirements](Requirements.md)

Source code for a rest api that handles messages, extracts palindrome size of substring and stores the messages to a database.

The docker-compose setup is a bit tricky. Fingers crossed, it might work with this:

From project directory, run the docker application:
run docker-compose up --build 

Open application in webbrowser:
http://localhost:8080/

and enter words. These will be stored to a database. You can query the words with the endpoint /messages.


------

if not working, run application locally:
-change in application.properties:  spring.datasource.url=jdbc:postgresql://database:5432/assignment
to spring.datasource.url=jdbc:postgresql://localhost:5432/assignment