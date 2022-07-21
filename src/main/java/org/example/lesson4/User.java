package org.example.lesson4;

public class User {
    private int number;

    public User(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" +
                "number=" + number +
                '}';
    }
}
