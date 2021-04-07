package edu.dnu.fpm.pz.list.core;

public class Item {
    private int value;

    public Item() {
        this.value = 0;
    }

    public Item(int value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        Item tmp = (Item)obj;
        return tmp.value == value;
    }
}
