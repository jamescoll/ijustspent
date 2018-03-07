# Budgetmaster

> Home budget application using Vue.js 2.x, Spring Boot 2.x, Webpack, 3.x and ES2015/ES6, with MongoDB


## Requirements
MongoDB
JDK 1.8
Maven
Node

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

## Notes on Version 0.1.0 Goals
Version one should be a 'type of' homebudget-lite but resting on a different database type https://itunes.apple.com/us/app/homebudget-lite-w-sync/id307620907?mt=8 - there is nothing particularly original in this school of applications but the useful functionality will come later. Really, it should be possible to create a much better user experience that homebudget lite which looks like a mobile app hacked into a UI..but the techincal challenge of re-creating it is useful in terms of learning what is good and what sucks - and how to create such an app.

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


