package ong.cnu.realcoding.controller;



import ong.cnu.realcoding.domain.Dog;
import ong.cnu.realcoding.service.DogmanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Dogcontroller{

    @Autowired
    private DogmanagementService dogmanagementServiece;

    @PostMapping("/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDogs(@RequestBody Dog dog){
        dogmanagementServiece.insertDog(dog);
    }

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
       return dogmanagementServiece.getAllDogs();
    }

    @GetMapping("/dogs/{name}")
    public Dog getDogByName(@PathVariable String name){
        return dogmanagementServiece.getDogByName(name);
    }



    @GetMapping("/dogs/,{ownerName}")
    public Dog getDogByOwnerName(@PathVariable String ownerName){
        return dogmanagementServiece.getDogByOwnerName(ownerName);
    }

    @GetMapping("/dogs/,,{ownerPhoneNumber}")
    public Dog getDogByOwnerPhoneNumber(@PathVariable String ownerPhoneNumber){
            return dogmanagementServiece.getDogByOwnerPhoneNumber(ownerPhoneNumber);
    }



    @GetMapping("/dogs/{name}/{ownerName}/{ownerPhoneNumber}")
    public Dog getDogByAll(@PathVariable String name,String ownerName, String ownerPhoneNumber ){
        return dogmanagementServiece.getDogByAll(name,ownerName,ownerPhoneNumber);
    }










}
