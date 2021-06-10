package com.projektjava.tablicaturniejowa;

import java.io.Serializable;

public class UserBean implements Serializable {
    int idUser;
    String name;
    String surname;
    String userName;
    String password;
    int idTournament;
    int points;

    public UserBean() {
    }

    public UserBean(int idUser, String name, String surname, String userName, String password, int idTournament, int points) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.password = password;
        this.idTournament = idTournament;
        this.points = points;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdTournament() {
        return idTournament;
    }

    public void setIdTournament(int idTournament) {
        this.idTournament = idTournament;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}


