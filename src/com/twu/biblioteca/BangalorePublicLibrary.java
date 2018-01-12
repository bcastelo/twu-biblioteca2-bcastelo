package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BangalorePublicLibrary {

    private List<ItemsToCheck> items = new ArrayList<ItemsToCheck>();
    private List<Client> clients = new ArrayList<Client>();

    public List<ItemsToCheck> getItems() {
        return items;
    }

    public void setItems(ItemsToCheck item) {
        items.add(item);
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(Client client) {
        clients.add(client);
    }

    public void listBooks() {
        System.out.println("\n\nList Books!");
        System.out.println("\n\tTitle \tAuthor \tYear Published");

        for (ItemsToCheck item : this.getItems()) {
            if(item.getClass() == Book.class) {
                try {
                    String nameClient = item.getClient().getName();
                    System.out.println(item.toString() +" "+ nameClient);
                } catch (Exception e){
                    System.out.println(item.toString() + " Disponible");
                }
            }
        }
    }

    public void listMovies() {
        System.out.println("\n\nList Movies!");
        System.out.println("\n\tTitle \tDirector \tYear \tRating");

        for (ItemsToCheck item : this.getItems()) {
            if(item.getClass() == Movie.class) {
                try {
                    String nameClient = item.getClient().getName();
                    System.out.println(item.toString() +" "+ nameClient);
                } catch (Exception e){
                    System.out.println(item.toString() + " Disponible");
                }
            }
        }
    }

    public void checkout(String type, Client client) {
        if(client != null && client.isAuthenticate()) {
            System.out.println("\nWhich Title do you like do checkout?");
            Scanner scanner = new Scanner(System.in);
            String title = scanner.nextLine();

            boolean existItem = findItem(title);

            if (existItem) {
                ItemsToCheck itemCheckOut = getItem(title);
                boolean typyItem = typeItem(type, itemCheckOut);
                if (typyItem) {
                    boolean itemIsDisponible = itemIsDisponible(title);
                    if (itemIsDisponible) {
                        setItemCheckOut(itemCheckOut, client);
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
        } else {
            System.out.println("User is not authenticate");
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

    public void setItemCheckOut(ItemsToCheck itemCheckOut, Client client) {
        itemCheckOut.setReservate(true);
        itemCheckOut.setClient(client);
    }

    public void returnItem(String type, Client client) {
        if(client != null && client.isAuthenticate()) {
            System.out.println("\nWhich Title do you like return?");
            Scanner scanner = new Scanner(System.in);
            String title = scanner.nextLine();

            boolean existItem = findItem(title);

            if (existItem) {
                ItemsToCheck itemCheckOut = getItem(title);
                boolean typyItem = typeItem(type, itemCheckOut);
                if (typyItem) {
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
        } else {
            System.out.println("User is not authenticate");
        }
    }

    public void setBookReturn(ItemsToCheck itemReturn) {
        itemReturn.setReservate(false);
    }

    public Client login() {
        Login doLogin = new Login();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Login: ");
        String login = scanner.nextLine();

        if(loginExist(login)) {
            Client client = getClient(login);
            if(doLogin.authenticate(client)){
                return client;
            } else {
                return null;
            }
        } else {
            System.out.println("Login not exist");
        return  null;
        }
    }

    private Client getClient(String login) {
        return this.getClients().stream().filter(o -> o.getLogin().equals(login)).findFirst().get();
    }

    private boolean loginExist(String login) {
        if((this.getClients().stream().filter(o -> o.getLogin().equals(login)).findFirst().isPresent())) {
            return true;
        } else {
            return false;
        }
    }
}
