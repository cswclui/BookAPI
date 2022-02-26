curl -s "\n" http://localhost:8080/books 
curl -s "\n" http://localhost:8080/books 
curl -s "\n" http://localhost:8080/books 
curl -s "\n" http://localhost:8080/books 
curl -s "\n" http://localhost:8080/books 

curl -s "\n" http://localhost:8080/books/1 

curl -X POST http://localhost:8080/books \
-H 'content-type: application/json' \
-d '{"title": "Spring in Action","author": "Craig Walls"}'

 curl -X PUT http://localhost:8080/books \
 -H 'content-type: application/json' \
 -d '{"id": 4,"title": "Spring in Acton 2nd Ed","author": "Craig Walls"}'

 curl -X DELETE http://localhost:8080/books/1