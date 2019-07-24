Eureka discovery server must be up and running Application services should be up and running

Config-server service should be up and running

Once the Config Client App is started it can be accessed:
http://localhost:8080/
Output:
app specific overriden value || global

##If you update any properties and commit the file config-client-app.properties file in the scf-config-repository repo then you can see the updated properties by 
http://localhost:8080/refresh
