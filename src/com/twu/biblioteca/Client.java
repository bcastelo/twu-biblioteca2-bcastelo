package com.twu.biblioteca;

public class Client {

    private String name;
    private String login;
    private String password;
    private String endereco;
    private String email;
    private String telefone;
    private boolean isAuthenticate;

    public Client(String name, String login, String password, String endereco, String email, String telefone){
        this.name = name;
        this.login = login;
        this.password = password;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    public Client(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getEmail(){
        return email;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setAuthenticate(boolean authenticate) {
        isAuthenticate = authenticate;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }
}

