package org.example.lesson6;

public class AbstractUser {

    @NonNull
    private String name;

    public AbstractUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void test() {}
}
