# EventTrackerProject

# Overview
This is a Jojo Bizarre Adventure web application. As of right now this application will let you be able to perform CRUD operations on Jojo Bizarre Adventure characters. The application will let you add a first name (Not Null), last name (Not null), age, height, weight, stand, image. The CRUD operations were tested using Postman.
# Update
05-13-22
Application was updated using javascript and XMLhttpRequests. The Jojo app now has a html page with Forms that allow the user to look up a jojo character by its id. They can also now update/create jojo characters by filling out the Forms. Lastly they can delete a jojo character by its id.

# REST API

| Return Type     | Route    | Functionality
| :------------- | :------------- | :-------------
| List<Joestar>       | GET api/jojo       | Gets all characters
| Joestar      | GET api/jojo/{id}       | Gets character by id
| Joestar      | GET api/jojo/search/{firstName}       | Gets character by their first  name
| Joestar      | POST api/jojo       | Creates character
| Joestar      | PUT api/jojo/{id}       | Updates character by id
| void      | DELETE api/jojo/{id}       | Deletes character by id

# Technologies

* Spring Tool Suite 4
* MYSQL WorkBench
* Postman
* Atom
* Terminal
* MAMP
* Javascript
* XMLhttpRequests
# Lessons

Lessons learned on this one would be using REST for my HTTP and Spring Data JPA for my CRUD operations. Using Postman to test my HTTP methods work. Also using JUNIT to test that MYSQL is communicating with Spring Boot and making sure what I request is what I get.
