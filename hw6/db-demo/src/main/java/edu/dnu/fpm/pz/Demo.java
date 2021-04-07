package edu.dnu.fpm.pz;

import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        ICRUD<Owner> ownerCRUD = new OwnerCRUD();

        Owner owner1 = new Owner(1,"Own1", "Own1", "City1");
        Owner owner2 = new Owner(2,"Own2", "Own2", "City2");

        ArrayList<Owner> list = new ArrayList<Owner>();
        list.add(owner1);
        list.add(owner2);

        ownerCRUD.saveAll(list);
        System.out.println("=================================");
        Collection<Owner> result = ownerCRUD.findAll();
        result.forEach(System.out::println);

        owner1.setSurname("QWERTY1");
        ownerCRUD.update(owner1);
        owner2.setSurname("QWERTY2");
        ownerCRUD.update(owner2);
        System.out.println("================================");
        System.out.println(ownerCRUD.findById(1));
        System.out.println(ownerCRUD.findById(2));

        ICRUD<Dog> dogCRUD = new DogCRUD();

        Dog dog1 = new Dog(owner1.getId(), "Dog1", 2, true);
        Dog dog2 = new Dog(owner2.getId(), "Dog2", 2, false);

        dogCRUD.save(dog1);
        dogCRUD.save(dog2);
        System.out.println("================================");
        Collection<Dog> resultCompanies = dogCRUD.findAll();
        resultCompanies.forEach(System.out::println);

        dog2.setName("DOG!!!!!!!!");
        dogCRUD.update(dog2);
        System.out.println("================================");
        System.out.println(dogCRUD.findById(1));
        System.out.println(dogCRUD.findById(2));

    }
}
