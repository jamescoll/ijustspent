## Sending requests twice from the front to the back-end

Requests seem to be coming in twice from the back to the front-end. This may have something to do with axios and how the interceptors are configured. To reproduce simply use any one of the current form services and observe the console. Verify, in mongo, that the data has been created twice 
