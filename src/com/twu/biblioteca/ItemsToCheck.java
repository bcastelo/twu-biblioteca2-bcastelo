package com.twu.biblioteca;

public class ItemsToCheck {

    private String title;
    private boolean reservate;

    public ItemsToCheck(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setReservate(boolean reservate){
        this.reservate = reservate;
    }

    public boolean getReservate(){
        return reservate;
    }
}
