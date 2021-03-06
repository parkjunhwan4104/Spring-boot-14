package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
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

    public void insertDog(Dog dog) {
        mongoTemplate.insert(dog);
    }

    public Dog findDogByName(String name) {
        return mongoTemplate
                .findOne(
                        Query.query(Criteria.where("name").is(name)),
                        Dog.class
                );
    }

    public Dog findDogByOwnerName(String ownerName) {
        return mongoTemplate
                .findOne(
                        Query.query(Criteria.where("ownerName").is(ownerName)),
                        Dog.class
                );
    }

    public Dog findDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        return mongoTemplate
                .findOne(
                        Query.query(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber)),
                        Dog.class
                );
    }

    public Dog findExactDog(String name, String ownerName, String ownerPhoneNumber) {
        Query query = new Query();
        Criteria criteria = new Criteria();

        Criteria criteria1[] = new Criteria[3];
        criteria1[0] = Criteria.where("name").is(name);
        criteria1[1] = Criteria.where("ownerName").is(ownerName);
        criteria1[2] = Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber);
        query.addCriteria(criteria.andOperator(criteria1));
        return mongoTemplate.findOne(query, Dog.class);
    }

    public List<Dog> findAllDog() {
        return mongoTemplate.findAll(Dog.class);
    }
}
