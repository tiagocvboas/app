# Simple app client

It allows the CRUD operation of companies and owners. And allows the company to add multiple owners all through a rest api.



Application is currently deployed [here](http://obscure-plains-83225.herokuapp.com/)
It includes a simple index.html with a link to the API documentation

I've also implemented the api the way I do at work, building the api's crud operations 
as generic as possible. And with the responsibility layers well defined.
 1. the data layer which includes dao's and entities
 2. the business layer which adds logic to it and transforms the entities 
 into dto's to avoid exposing the entities to the webservice
 3. the webservice layer which only exposes the business layer methods and 
 translates the exceptions and responses in proper http responses

The maven dependencies aren't totally right, since there's visibility of entities on the webservice layer which I didn't fix yet,
But the idea is that it shouldn't be able to see them.


## Documentation

Added swagger Documentation to the project [here](http://obscure-plains-83225.herokuapp.com/docs/index.html) and [here](http://obscure-plains-83225.herokuapp.com/swagger-ui.html)

Since for some time the embedded version of the swagger-ui wasn't working so 
I've added it as static content and fixed the url to point to the root of the api 
which is running [here](http://obscure-plains-83225.herokuapp.com/api)

//TODO add more documentation to the methods 

## About the project and a couple of thoughts

It's my first time using spring boot, and spring mvc for rest api's, i've been using jax-rs and the standard javaEE stack since forever. I tried to organize the project in modules but the dependencies are not yet as i'm used to, have three clear layers, data (dao's), business(everything related with dao's and data) and the client(webservice layer).

I decided not to do the frontend application, although I'm currently working on a project with vue.js as tech leader, it would take me a lot of time since my  focus over the last 1 and a half years have been backend.

I also didn't doc the api documents on the README.me since I decided to add Swagger to the project, 

## Questions:

### You do not need to add authentication to your web service, but propose a protocol / method andjustify your choice.*
//TODO

### How can you make the service redundant? What considerations should you do?

 //TODO

