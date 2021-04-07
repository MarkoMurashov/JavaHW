package edu.dnu.fpm.pz;

import java.util.Objects;

public class City {
    private String name;
    private String state;
    private long population;

    public City(String name, String state, long population) {
        this.name = name;
        this.state = state;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public long getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return name + ", " + population;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof City))
            return false;

        City city = (City) obj;

        return getPopulation() == city.getPopulation() &&
                Objects.equals(getName(), city.getName()) &&
                Objects.equals(getState(), city.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getState(), getPopulation());
    }
}
