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

## Milestone 0.0.13
Found a fully working JWT implementatoin with mongo that does ALL the things.. thank fuck
https://github.com/vlsidlyarevich/Spring-Boot-MongoDB-JWT

## Milestone 0.0.14
Committed implementation of JWT but not quite working yet. Need to refactor BasicUserService so that it returns only one
user - this requires a mongoclient and this kind of code https://stackoverflow.com/questions/30625380/find-in-mongocollectiondocument

## Milestone 0.0.15
Authentication with bcrypt storing encrypted passwords now works. unit test
added to test AuthenticationController. Auth is now 'good enough' to focus on something
else. Later on an admin window for adding roles and users will be necessary but not now.
Next focus on organizing the logic in the back end, tidying up the code, putting code headers on and static values
and then get working on the Front end where the real fun will be

## Milestone 0.0.16
Fixed issue with user null dup exception by removing unique constraint on user. However, a unique constraint on user is needed
so need to work out some way to filter users on create so this doesn't occur. don't know what best practice is but fuck it...this
was very annoying. unit test this stuff next. This mostly worked out just need to work out field for unit test

## Milestone 0.0.17
Made front-end less horrible and added placeholders for three of the main areas of functionality. Got rid of a lot of cruddy deleteme methods and left one in place to dynamically load to a table.

## Milestone 0.0.18
Completed chart placeholder and fixed incorrect image link

## Milestone 0.0.19
Completed edit placeholder and form. Also renamed app to budget.io

## Milestone 0.0.20
Much improved the front-end placeholders by adding navbar, bootstrap grids, logout in appropriate place and others. Will need to add methods to detect whether user is logged in and act appropriately but placeholders are now much better looking

## Milestone 0.0.21
Added basic conditional display to logout - it is time to sketch out the model and start to make components - what needs to be done here is to - get a wireframe of the intended UI - create a UML diagram of the model - work out how to communicate between components in vue

## Milestone 0.0.22
Added panels for entering data into all of the models. There is now a rough and ready - admin entry area. Need to work out how to get conditional loading working - service calls before load but otherwise in good shape

## Milestone 0.0.23
Got service working and returning for accounttype. Now it is a question of mapping that to each other account and potentially installing vuex for monitoring app state

## Milestone 0.0.24
Got rudimentary account page working with checkbox and datepicker - nothing beautiful but ...it's functiona

## Milestone 0.0.25
Fixing endpoints in controllers so to be standardized. Also adding functionality so user edits can be tracked in documents

## Milestone 0.0.26
Changing directory structure to introduce mobile and web-app folders. Adding wireframe for mobile. Changing name to ijustspent

## Milestone 0.0.27
Added expense form, got sample data for expense categories and account types. 
