package org.example.lesson6;


public class User6 extends AbstractUser {
    private int count;

    public User6(Integer count, String name) {
        super(name);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Min
    public void setCount(int count) {
        this.count = count;
    }

    public static class Test {
    }

    @Override
    public String toString() {
        return "User6{" +
                "count=" + count +
                '}';
    }
}
