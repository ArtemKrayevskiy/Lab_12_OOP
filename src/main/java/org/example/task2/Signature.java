package org.example.task2;


import java.util.function.Consumer;

public class Signature<T> extends Task<T> {
    public Consumer<T> consumer;
    private Visitor visitor = new Visitor();
    public Signature(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    public void apply(T arg) {
        this.freeze();
        this.visitor.forSignature(this, this.getHeaders());
        consumer.accept(arg);
    }
}
