package ong.cnu.realcoding.service;


import ong.cnu.realcoding.Repository.DogRepository;
import ong.cnu.realcoding.domain.Dog;
import ong.cnu.realcoding.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DogmanagementService {
   @Autowired
   private DogRepository dogRepository;

    public void insertDog(Dog dog) {
        dogRepository.insertDog(dog);

    }

    public Dog getDogByName(String name) {
        Dog dog=dogRepository.findDogByName(name);

        if(dog==null){
            throw new NotFoundException();
        }
        return dog;
    }



    public List<Dog> getAllDogs() {
        return dogRepository.getAllDogs();
    }

    public Dog getDogByOwnerPhoneNumber(String ownerPhoneNumber){
        Dog dog=dogRepository.findDogByOwnerPhoneNumber(ownerPhoneNumber);

        if(dog==null){
            throw new NotFoundException();
        }
        return dog;
    }


    public Dog getDogByOwnerName(String ownerName) {
        Dog dog=dogRepository.findDogByOwnerName(ownerName);

        if(dog==null){
            throw new NotFoundException();
        }
        return dog;
    }



    public Dog getDogByAll(String name, String ownerName, String ownerPhoneNumber) {
        Dog dog=dogRepository.findDogByAll(name,ownerName,ownerPhoneNumber);

        if(dog==null){
            throw new NotFoundException();
        }
        return dog;
    }


}
