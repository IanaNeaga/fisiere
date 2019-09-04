package com.sda.fisiere;

import java.util.LinkedList;
import java.util.List;

public class MainLegacy {

    public static void main(String[] args) {
        IFileManipulator legacy=new LegacyFileManipulator();
        //citim din fisierul de pe desktop
        List<String> lines = legacy.readFromFile(PathType.ABSOLUTE);
        System.out.println("Continut fisier de la path absolut (citire): ");
        printLines(lines);

        //citim din fisierul din resources (vezi target/classes)
        List<String> relativePathFileContent=legacy.readFromFile(PathType.RELATIVE);
        System.out.println("Continut fisier de la path relativ (citire): ");
        printLines(relativePathFileContent);

        //scriem in fisier de la path relativ
        System.out.println("Scriem in fisier");
        legacy.writeToFile(lines,true);
        System.out.println("Continut actualizat fisier de la path relativ (citire): ");
        printLines(legacy.readFromFile(PathType.RELATIVE));
    }

    private static void printLines(List<String> lines) {
        for(String line:lines){
            System.out.println(line);
        }
    }
}
