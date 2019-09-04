package com.sda.fisiere.serializare;

import java.io.Serializable;

//Serializare inseamna salvarea in fisier a unui obiect Java (a unei clase)
public class Person implements Serializable {
    private String nume;
    private int varsta;
    private transient String cnp;

    public Person(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
    }

    public int getVarsta() {
        return varsta;
    }

    public String getNume() {
        return nume;
    }
}
