package com.example.demostreamapi;

public class Vietnam implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Xin chào " + name);
    }
}
