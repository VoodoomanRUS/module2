package org.example.store;

public class Store <T extends Good> {
    private T good;

    public Store(T good) {
        this.good = good;
    }

    public T getGood() {
        return good;
    }

    public void setGood(T good) {
        this.good = good;
    }
}
