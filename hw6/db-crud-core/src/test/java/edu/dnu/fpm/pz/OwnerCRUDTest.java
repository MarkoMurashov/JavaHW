package edu.dnu.fpm.pz;

import org.junit.AfterClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.sql.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;

public class OwnerCRUDTest
{
   /* private static ICRUD<Owner> ownerCRUD = new OwnerCRUD();

    @AfterClass
    public static void clean() {
        for (int i = 1; i <= 8; i++) {
            ownerCRUD.delete(i);
        }
    }

    @Test
    public void save() throws Exception {
        //GIVEN
        Owner owner1 = new Owner(1,"Own1", "Own1", "City1");
        Owner owner2 = new Owner(2,"Own2", "Own2", "City2");

        //WHEN
        ownerCRUD.save(owner1);
        ownerCRUD.save(owner2);

        //THEN
        assertThat(ownerCRUD.findAll(), hasItem(owner1));
        assertThat(ownerCRUD.findAll(), hasItem(owner2));
    }

    @Test
    public void saveAll() {
        //GIVEN

        Owner owner3 = new Owner(3,"Own3", "Own3", "City3");
        Owner owner4 = new Owner(4,"Own4", "Own4", "City4");

        //WHEN
        ownerCRUD.saveAll(Arrays.asList(owner3, owner4));

        //THEN
        assertThat(ownerCRUD.findAll(), hasItem(equalTo(owner3)));
        assertThat(ownerCRUD.findAll(), hasItem(equalTo(owner4)));
    }

    @Test
    public void findAll() throws Exception {
        //GIVEN
        Owner owner5 = new Owner(5,"Own5", "Own5", "City5");
        ownerCRUD.save(owner5);

        //When
        Collection<Owner> all = ownerCRUD.findAll();

        //Then
        assertThat(all, hasItem(equalTo(owner5)));
    }

    @Test
    public void update() throws Exception {
        //Given
        Owner owner6 = new Owner(6,"Own6", "Own6", "City6");
        ownerCRUD.save(owner6);
        owner6.setName("!!!");

        //When
        ownerCRUD.update(owner6);

        //Then
        Owner founderFromDb = ownerCRUD.findById(6);
        assertThat(founderFromDb.getName(), equalTo("!!!"));
    }

    @Test
    public void delete() throws Exception {
        //Given
        Owner owner7 = new Owner(7,"Own7", "Own7", "City7");
        ownerCRUD.save(owner7);

        //When
        ownerCRUD.delete(7);

        //Then
        Owner founderFromDb = ownerCRUD.findById(7);
        assertThat(founderFromDb, is(nullValue()));
    }

    */
}

