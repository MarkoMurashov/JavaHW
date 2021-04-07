package edu.dnu.fpm.pz;

import edu.dnu.fpm.pz.list.core.IndexedList;
import edu.dnu.fpm.pz.list.exception.WrongIndex;
import edu.dnu.fpm.pz.list.exception.WrongLength;
import edu.dnu.fpm.pz.list.interfaces.IList;

public class App 
{
    public static void main( String[] args )
    {
        startIntListWork();

        strartStringListWork();
    }

    private static void startIntListWork(){
        IList<Integer> list = new IndexedList<>();

        for(int i = 0; i < 10; i++)
        {
            list.add(i);
        }

        System.out.println("======================================");

        //add
        addItemToList(list, 11);

        //find and insert
        insertItemToList(list, 5,1865);

        //remove
        removeItemFromList(list,8);

        //errors
        handleListErrors(list, 888, 999);

        System.out.println("======================================");
    }

    private static void strartStringListWork(){

        IList<String> list = null;

        //with wrong length
        System.out.println("Create with wrong capacity: ");
        try {
            list = new IndexedList<>(-100);
        }
        catch (WrongLength e){
            e.log();
        }


        try {
            list = new IndexedList<>(100);
        }
        catch (WrongLength e){
            e.log();
            return;
        }


        for(int i = 0; i < 10; i++)
        {
            list.add("A");
        }

        //add
        addItemToList(list, "B");

        //find and insert
        insertItemToList(list, 5, "(!C!)");

        //remove
        removeItemFromList(list, 5);

        //errors
        handleListErrors(list, 888, "D");

        System.out.println("======================================");
    }

    private static <T> void showList(IList<T> list){
        for(int i = 0; i < list.length(); i++)
        {
            try {
                System.out.print(list.find(i) + " ");
            }
            catch (WrongIndex e){
                e.log();
            }
        }
    }

    private static <T> void addItemToList(IList<T> list, T item){
        System.out.println("Length before adding " + (list.length()));
        list.add(item);
        System.out.println("Length after adding " + (list.length()));

    }

    private static <T> void insertItemToList(IList<T> list, int index, T item){
        System.out.println("List before inserting: ");
        showList(list);

        try{
            list.insert(index, item);
        }
        catch (WrongIndex e){
            e.log();
        }
        System.out.println("\nList after inserting: ");
        showList(list);

    }

    private static <T> void removeItemFromList(IList list, int index){
        System.out.println("\nList before removing: ");
        showList(list);

        try{
            list.removeAt(index);
        }
        catch (WrongIndex e){
            e.log();
        }
        System.out.println("\nList after removing: ");
        showList(list);
    }

    private static <T> void handleListErrors(IList list, int index, T item){
        System.out.println("\nRemove with wrong index: ");
        try{
            list.removeAt(index);
        }
        catch (WrongIndex e){
            e.log();
        }
        System.out.println("Insert with wrong index: ");
        try{
            list.insert(index, item);
        }
        catch (WrongIndex e){
            e.log();
        }
    }

}
