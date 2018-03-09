## Sending requests twice from the front to the back-end

Requests seem to be coming in twice from the back to the front-end. This may have something to do with axios and how the interceptors are configured. To reproduce simply use any one of the current form services and observe the console. Verify, in mongo, that the data has been created twice

## Unit tests for filtering failing

Unit tests for corsfiltering are failing or incomplete. Also need to add a section in the payee tests for the user modify hash-map 
