
// To execute a JavaScript file in mongo shell write:
// load("myfile.js")


//show databases
//show dbs;
// create database
use nuwe-db;
// create collection
db.createCollection("users");

// switch to database
use nuwe-db;

// insert data
db.users.insertOne([
{
  "id": 1,
  "username" :"user1",
  "age" : 40,
  "city": "Barcelona"
}
])

// to read
db.users.find({}).pretty();

