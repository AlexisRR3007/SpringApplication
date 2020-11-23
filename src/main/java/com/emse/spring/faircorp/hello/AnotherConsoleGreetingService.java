package com.emse.spring.faircorp.hello;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class AnotherConsoleGreetingService implements GreetingService {
    public void greet(String name) {
        System.out.println("Bonjour, " + name + "!");
    }
}
