
// To execute a JavaScript file in mongo shell write:
// load("myfile.js")


//show databases
//show dbs;
// create database
use nuwe-database;
// create collection
db.createCollection("users");


// switch to database
use nuwe-database;


// OR insert User and Admin
db.users.insert([{
    "_id": "621c09a9cf6edf58b3dad0b5",
	"email": "user@mail.com",
	"password": "abc123",
	"role": "User"
},{
    "_id": "621c09a9cf6edf58b3dad0b6",
  	"email": "admin@mail.com",
  	"password": "admin123",
  	"role": "Admin"
  }]
)

// to read
db.users.find({}).pretty();

