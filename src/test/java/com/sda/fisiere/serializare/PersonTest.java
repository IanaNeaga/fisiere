package com.sda.fisiere.serializare;

import com.sda.fisiere.IFileManipulator;
import com.sda.fisiere.ModernFileManipulator;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person = new Person("Gheorghe", 18);

    @Test
    public void testSerializare() {
        String pathAddress = PersonTest.class
                .getClassLoader()
                .getResource("person.txt")
                .getPath()
                .replace("%20", " ");
        File file = new File(pathAddress);

        writeObjectToFile(file);

        //declaram un obiect de tip Person care va contine obiectul citit din fisier
        Person readPerson=readPersonFromFile(file);

        //verificam ca am reusit sa citim ceva
        assertNotNull(readPerson);
        System.out.println(readPerson.getNume());
        System.out.println(readPerson.getVarsta());
    }

    private Person readPersonFromFile(File file) {
        //varianta legacy, din acelasi motiv ca in metoda write
        Person readPerson=null;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream =
                     new ObjectInputStream(fileInputStream)) {
            //citim din fisier un obiect, pe care il castam la Person
            readPerson = (Person) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return readPerson;
    }

    private void writeObjectToFile(File file) {
        //folosim metode si clase legacy - java.io
        //deoarece avem nevoie de ObjectOutputStream
        //care face parte din java.io si nu din java.nio
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            //aici se scrie in fisier obiectul
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}