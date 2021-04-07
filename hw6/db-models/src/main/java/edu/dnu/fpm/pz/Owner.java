package edu.dnu.fpm.pz;

import java.util.Objects;

public class Owner {
    private Integer id;
    private String Name;
    private String Surname;
    private String City;

    public Owner(String name, String surname,String city) {
        Name = name;
        Surname = surname;
        City = city;
    }

    public Owner(Integer id, String name, String surname, String city) {
        this.id = id;
        Name = name;
        Surname = surname;
        City = city;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Owner))
            return false;

        Owner person = (Owner) o;

        return Objects.equals(Name, person.getName()) &&
                Objects.equals(Surname, person.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), Name, Surname);
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\nName: " + Name +
                "\nSurname: " + Surname +
                "\nCity: " + City;
    }
}
