# Budgetmaster

> Home budget application using Vue.js 2.x, Spring Boot 2.x, Webpack, 3.x and ES2015/ES6, with MongoDB


## Requirements
MongoDB
JDK 1.8

## Usage

Install and start the server end.

```
$ mvn install
$ mvn spring-boot:run
```

Start the front end dev server

```
$ cd src/main/front-end
$ npm run dev
```

Package the project

```
$ mvn package
```

Run all tests

```
$ mvn test
```

Run front end tests

```
$ cd src/main/front-end
$ npm run e2e
$ npm run unit
$ npm run test
```

## Technology Stack
- Vue 2.4.2
- Bootstrap 4.0.0-beta
- Spring Boot 2.0.0.M2
- Spring Framework 5.0
- Webpack 3.6.0

## Version 0.1.0 Goals
As a user I can add all my expense, account and other information - view montly and weekly rollups in a chart
- and view associated icons for each of the categories. I am doing this in a basic environment using vue components

## Version 0.2.0 Goals
As a user I can authenticate with Google, Facebook as well as with local, I am redirected to login if I am unauthenticated,
blocked from adding data to the db and prevented from seeing other users data

## Version 0.3.0 Target
As a user I can add transactions from my device for any purchase I do ... whether it be cash, card or other. I can then view
data about the effects of those transactions.

## Version 1.0.0 Target
As a user I can send any transaction to Budgetmaster and see the effect of that transaction and how it contributes to my plan. As a data user
I can view metadata about how communities of people are spending their money in various data slices.

## Version 2.0.0 Target
As a user I can send any transaction from any device to Budgetmaster and see the effect of that transaction and how it contributes to my plan. I can set
 targets, view savings timelines and other associated goals. As a data user, I can view metadata about how communities of people are spending their money in various data slices.

## TODOS for version 1.0.0 Target
Learn about Google, Facebook auth
Learn about Spring Security auth combined with js frontend
Learn how to make awesome charts with D3.js
Learn about mongo partitioning and sharding as well as setting global values programmatically (schema version etc..)
Learn how to add geocoding information to transactions and how to anonymise user from transaction

## Milestone 0.0.2
Used initial spring-vue boot skin and experimented with using highcharts and d3.js


## Milestone 0.0.3
Added models for expenses and incomes
Added repositories for expenses and incomes
Added test data populator
Configured application properties
Added date between method for future calendar work
Added controllers for expenses and income items
Added lombok support

## Milestone 0.0.4
Added models for Accounts and Account transactions with repositories
Attempted to use builders but removed
Bulked up Payee class
Added icon location field - research how to make auto empty
Removed/redundified a lot of code in ExpenseService and TestData...
Should be finished with basic required models in milestone 0.0.5

## Milestone 0.0.5
Added BaseDocument class to add createstamps, partition key, schema version and sim
Removed much boilerplate
Tested base methods
Still need to do base icon class and think on transactions
Start on front-end forms soon

## Milestone 0.0.6
Wrote all controller classes
Nothing present for validation
Some controllers don't seem to be working...it's also possible to add extra fields..
Approach with /asdf/{id}/asdf{id} is still best although cludgy looking
http://bytepadding.com/spring/spring-data-mongodb-validation/
https://docs.mongodb.com/manual/core/schema-validation/

## Milestone 0.0.7
Added front end payee server (look at best practice for this)
Tested service (all but deleteAll working... removed this..it's nuclear anyway)
Need to create other services on same model
Investigated this - buggy works with app props line commented https://dzone.com/articles/spring-boot-with-spring-security-andnbspnosql

## Milestone 0.0.8
Fixed issue with deleteAll
Added all front-end services (untested)
https://developer.okta.com/blog/2017/09/14/lazy-developers-guide-to-auth-with-vue

## Milestone 0.0.9
Created unit tests for payee controller and payee repository
These can be models for the other tests
Failed to resolve setting properties issue on base abstract class
Todo - add class header with author and etc.. to code files
Don't spent too long on tests as it's better to focus on adding users/auth and front end components
Todo - add logging support and jwt on the vue side

## Milestone 0.0.10
Jwt working but not redirects... model is auth_guard on meta - see router.js
It's very basic and only works on redefined users..needs doing are 1.) functional redirects 2.) user profiles
3.) user docs 4.) proper sign-up functionality

## Milestone 0.0.11
Jwt working but not with attempted set-up of mongo user details and mongouser detgails service.. this hack
broke functionality but when it works will allow for multiuser and multirole setup until something better
is in place

## Milestone 0.0.12
Jwt and token attaching on front-end - get authentication fully and functioning from mongo to complete this part of the piece
- frustrating to get the mongouserdetails object loading correctly

##Milestone 0.0.13
Found a fully working JWT implementatoin with mongo that does ALL the things.. thank fuck
https://github.com/vlsidlyarevich/Spring-Boot-MongoDB-JWT