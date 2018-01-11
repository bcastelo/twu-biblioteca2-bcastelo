package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BangalorePublicLibrary {

    private List<ItemsToCheck> items = new ArrayList<ItemsToCheck>();

    public List<ItemsToCheck> getItems() {
        return items;
    }

    public void setItems(ItemsToCheck item) {
        items.add(item);
    }

    public void listBooks() {
        System.out.println("\n\nList Books!");
        System.out.println("\n\tTitle \tAuthor \tYear Published");

        for (ItemsToCheck item : this.getItems()) {
            if(item.getClass() == Book.class) {
                System.out.println(item.toString());
            }
        }
    }

    public void listMovies() {
        System.out.println("\n\nList Movies!");
        System.out.println("\n\tTitle \tDirector \tYear \tRating");

        for (ItemsToCheck item : this.getItems()) {
            if(item.getClass() == Movie.class) {
                System.out.println(item.toString());
            }
        }
    }

    public void checkout(String type) {

        System.out.println("\nWhich Title do you like do checkout?");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        boolean existItem = findItem(title);

        if(existItem){
            ItemsToCheck itemCheckOut = getItem(title);
            boolean typyItem = typeItem(type, itemCheckOut);
            if(typyItem) {
                boolean itemIsDisponible = itemIsDisponible(title);
                if(itemIsDisponible) {

                    setItemCheckOut(itemCheckOut);
                    System.out.println("Thank you! Enjoy the item");
                } else {
                    System.out.println("That item is not available.");
                }
            } else {
                System.out.println("That item is not available.");
            }
        } else {
            System.out.println("That item is not available.");
        }
    }

    private boolean typeItem(String type, ItemsToCheck item) {
        if(type.equals("Movie")) {
            return (item.getClass() == Movie.class);
        } else {
            return (item.getClass() == Book.class);
        }
    }

    public boolean findItem(String title) {
        if((this.getItems().stream().filter(o -> o.getTitle().equals(title)).findFirst().isPresent())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean itemIsDisponible(String title) {
        if(((this.getItems().stream().filter(o -> o.getTitle().equals(title)).findFirst().get().getReservate()) == false)) {
            return true;
        } else {
            return false;
        }
    }

    public ItemsToCheck getItem(String title) {
        return this.getItems().stream().filter(o -> o.getTitle().equals(title)).findFirst().get();
    }

    public void setItemCheckOut(ItemsToCheck itemCheckOut) {
        itemCheckOut.setReservate(true);
    }

    public void returnItem(String type) {

        System.out.println("\nWhich Title do you like return?");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        boolean existItem = findItem(title);

        if (existItem) {
            ItemsToCheck itemCheckOut = getItem(title);
            boolean typyItem = typeItem(type, itemCheckOut);
            if(typyItem) {
                boolean itemIsDisponible = itemIsDisponible(title);
                if (!itemIsDisponible) {
                    setBookReturn(itemCheckOut);
                    System.out.println("Thank you for returning the item.");
                } else {
                    System.out.println("That is not a valid item to return.");
                }
            } else {
                System.out.println("That is not a valid item to return.");
            }
        } else {
            System.out.println("That is not a valid item to return.");
        }
    }

    public void setBookReturn(ItemsToCheck itemReturn) {
        itemReturn.setReservate(false);
    }

}
