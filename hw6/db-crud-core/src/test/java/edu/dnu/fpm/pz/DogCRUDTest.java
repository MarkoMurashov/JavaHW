package edu.dnu.fpm.pz;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;

public class DogCRUDTest {
    /*
    private static ICRUD<Dog> dogCRUD = new DogCRUD();
    private static ICRUD<Owner> ownerCRUD = new OwnerCRUD();

    @BeforeClass
    public static void init() {
        ArrayList<Owner> owners = new ArrayList<>();
        owners.add(new Owner("Own1", "Own1", "City1"));
        owners.add(new Owner("Own2", "Own2", "City2"));
        owners.add(new Owner("Own3", "Own3", "City3"));
        owners.add(new Owner("Own4", "Own4", "City4"));
        owners.add(new Owner("Own5", "Own5", "City5"));

        ownerCRUD.saveAll(owners);
    }

    @AfterClass
    public static void clean() {
        for (int i = 1; i <= 8; i++) {
            dogCRUD.delete(i);
        }

        for (int i = 1; i <= 5; i++) {
            ownerCRUD.delete(i);
        }
    }

    @Test
    public void save() throws Exception {
        //GIVEN
        Dog dog1 = new Dog(1, "Dog1", 5, true);
        Dog dog2 = new Dog(2, "Dog2", 3, false);

        //WHEN
        dogCRUD.save(dog1);
        dogCRUD.save(dog2);

        //THEN
        assertThat(dogCRUD.findAll(), hasItem(equalTo(dog1)));
        assertThat(dogCRUD.findAll(), hasItem(equalTo(dog2)));
    }


    @Test
    public void saveAll() {
        //GIVEN
        Dog dog3 = new Dog(3, "Dog3", 5, false);
        Dog dog4 = new Dog(4, "Dog4", 5, true);

        //WHEN
        dogCRUD.saveAll(Arrays.asList(dog3, dog4));

        //THEN
        assertThat(dogCRUD.findAll(), hasItem(equalTo(dog3)));
        assertThat(dogCRUD.findAll(), hasItem(equalTo(dog4)));
    }


   @Test
    public void findAll() throws Exception {
        //GIVEN
        Dog dog5 = new Dog(5,5, "Dog5", 1, false);
        dogCRUD.save(dog5);

        //When
        Collection<Dog> all = dogCRUD.findAll();

        //Then
        assertThat(all, hasItem(equalTo(dog5)));
    }

    @Test
    public void update() throws Exception {
        //Given
        Dog dog6 = new Dog(1,5, "!!!",2, true);

        //When
        dogCRUD.update(dog6);

        //Then
        assertThat(dogCRUD.findAll(), hasItem(equalTo(dog6)));
    }

    @Test
    public void delete() throws Exception {
        //Given
        Dog dog7 = new Dog(7,5, "Dog7", 2, true);
        dogCRUD.save(dog7);

        //When
        dogCRUD.delete(7);

        //Then
        Dog companyFromDb = dogCRUD.findById(7);
        assertThat(companyFromDb, is(nullValue()));
    }
    */
}
