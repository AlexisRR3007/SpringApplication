package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService {

    private final GreetingService GreetingS;

    @Autowired
    public DummyUserService(GreetingService pGreetingS) {
        this.GreetingS = pGreetingS;
    }

    public void greetAll() {
        String Tableau[] = {"Elodie","Charles"};
        GreetingS.greet(Tableau[0]);
        GreetingS.greet(Tableau[1]);
    }

}
