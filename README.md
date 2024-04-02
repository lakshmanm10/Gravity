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

Alternative Approach:

1) Go to GravitySpringboot/target
2) Go to terminal and run
   java -jar GravitySpringboot-0.0.1-SNAPSHOT.jar
3)  Open PostMan and call the below Urls
   a) localhost:8080/firstOffer
   b) localhost:8080/secondOffer
   c) localhost:8080/thirdOffer
   Use the below Request structure as input data
 
   {
    "items": [10,20,30,40,40,50,60,60]
    }


Docker Approach

1) Go to GravitySpringboot
2) run the following command in terminal "docker build -t gravity-boot"
3) run the command "docker images" to get the image id
4) run the command "docker run -p8002:8080 <image_id>"
5)  Open PostMan and call the below Urls
   a) localhost:8002/firstOffer
   b) localhost:8002/secondOffer
   c) localhost:8002/thirdOffer
   Use the below Request structure as input data
 
   {
    "items": [10,20,30,40,40,50,60,60]
    }
