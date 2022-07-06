package org.example.computer;

public class Computer<T extends Input, V> {
    private T input;
    private V output;

    public Computer(T input, V output) {
        this.input = input;
        this.output = output;
    }

    public T getInput() {
        return input;
    }

    public V getOutput() {
        return output;
    }
}
