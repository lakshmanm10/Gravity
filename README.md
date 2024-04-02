Steps to Run the Gravity SpringbootApplication

1) Import the GravitySpringboot application into STS
2) Resolve all the pom.xml by running "maven clean build"
3) Run the Main project of the springboot application.
4) Open PostMan and call the below Urls
   a) localhost:8080/firstOffer
   b) localhost:8080/secondOffer
   c) localhost:8080/thirdOffer
   Use the below Request structure as input data
 
   {
    "items": [10,20,30,40,40,50,60,60]
    }
