package ong.cnu.realcoding.Repository;

import ong.cnu.realcoding.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


    public Dog findDogByName(String name){

        return mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)),
                        Dog.class
                );
    }



    public Dog findDogByOwnerPhoneNumber(String ownerPhoneNumber){

        return mongoTemplate.findOne(Query.query(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber)),
                        Dog.class
                );
    }

    public Dog findDogByOwnerName(String ownerName) {
        return mongoTemplate.findOne(Query.query(Criteria.where("ownerName").is(ownerName)),
                Dog.class
        );
    }



    public Dog findDogByAll(String name, String ownerName, String ownerPhoneNumber) {

        return mongoTemplate.findOne(Query.query(Criteria.where("name").is(name).and("ownerName").is(ownerName).and("ownerPhoneNumber").is(ownerPhoneNumber)),
                Dog.class
               );
    }



    public void insertDog(Dog dog) {
        mongoTemplate.insert(dog);
    }

    public List<Dog> getAllDogs() {
        return mongoTemplate.findAll(Dog.class);
    }



}
