## Product Microservice

Creating The DTO Folder?

DTO --> Contains the Entity

The It is Used (Modified) By the Service section.

service section mthod is called by the 

Cntroller

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

DTO --interfaced--> Repository -->  Service --> Controller

- Next Import into service section
`private ProductRepository productRepository`
And Replace the logic using DB `MongoRepository` queries now.