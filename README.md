## Product Microservice

Creating The DTO Folder?

DTO --> Contains the Entity

The Entity, It is Used (Modified) By the Service section.

service section mthod is called by the 

Controller

DTO --> Service --> Controller


### Adding MongoDB
Using MongoDB we have to save the product before sending to the controller
- Install Mongo Dependency
- Create a Repository to Save product on DB.

The Repository:-
```java
@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
}
```
while you annotate your Product entity with `@Document` and id `@Id` 
- In Sql we use `@Table` but since we are using a noSql we refer to 
`@Document(collection="nameCollection"}`

To auto generate id in MongoDB make the ID type a String

DTO --interfaced--> Repository -->  Service --> Controller

- Next Import into service section
`private ProductRepository productRepository`
And Replace the logic using DB `MongoRepository` queries now...

### Using Lombok

### REST API Data Validation
To validate effectively if users are inserting the right data install Validation I/O
Bean Validation with Hibernate validator.

Using the validation dependency
it provides us with annotations like (`notnull`, `@min`, `@max`, etc) to check and validate the data before saving it.

After using the annotation
Head to the controller and use `@Valid` annotation as an argument of the create method 

### Custom Exception Handling
Adding Business logic to add further validation cases using custom exception handler.

Create A Custom Class OfferNotValidException.

And A `@ControllerAdviser` CustomExceptionHandler Class which has an `@ExceptionHandler` annotation that refers to OfferNotValidException

```json
{
    "status": "BAD_REQUEST",
    "errors": [
        "class com.longbridge.product.exception.OfferNotValidException:No discount is allowed @ 0 price"
    ],
    "timeStamp": "2022-06-15T02:21:41.5808854",
    "pathUri": "uri=/v1/product/save;client=0:0:0:0:0:0:0:1"
}
```

Adding an Overide method in other to dsiplay custom message attached to the validation annotations in the Entity classed.



#### Building Gradle File Artifact
- Build
`gradlew clean build`
- Run
`Java -jar product-0.0.1-SNAPSHOT.jar`
- Adding Configuration from command line (But This Method Would Override the production.curries config  set in the application.yaml file)
`Java -jar product-0.0.1-SNAPSHOT.jar --product.currencies[0]=AUD --product.currencies[1]=INR`
- Better method to pass config 

### Adding Configurations

