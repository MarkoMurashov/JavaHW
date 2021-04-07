package edu.dnu.fpm.pz;

import java.sql.Date;
import java.util.Objects;

public class Dog {
    private Integer id;
    private Integer OwnerId;
    private String Name;
    private Integer Age;
    private Boolean IsVaccinated;

    public Dog(Integer owner, String name, Integer age,Boolean isVaccinated) {
        OwnerId = owner;
        Name = name;
        Age = age;
        IsVaccinated = isVaccinated;
    }

    public Dog(Integer id, Integer owner, String name, Integer age,Boolean isVaccinated) {
        this.id = id;
        OwnerId = owner;
        Name = name;
        Age = age;
        IsVaccinated = isVaccinated;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() { return OwnerId; }

    public void setOwnerId(Integer id) {
        OwnerId = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Boolean getIsVaccinated() {
        return IsVaccinated;
    }

    public void setIsVaccinated(Boolean isVaccinated) {
        IsVaccinated = isVaccinated;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dog))
            return false;

        Dog d2 = (Dog) o;

        return
                Objects.equals(OwnerId, d2.getOwnerId()) &&
                Objects.equals(Name, d2.getName()) &&
                Objects.equals(Age, d2.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), OwnerId, Name);
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\nOwnerId: " + OwnerId +
                "\nName: " + Name +
                "\nAge:" + Age  +
                "\nIsVaccinated:" + IsVaccinated;
    }
}
