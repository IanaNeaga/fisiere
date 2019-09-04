package com.sda.fisiere;

import java.util.List;

public interface IFileManipulator {

    String ABSOLUTE_PATH="C:\\Users\\neaga\\Desktop\\absoluteFile.txt";
    String RELATIVE_PATH=IFileManipulator.class.getClassLoader().getResource("relativeFile.txt").getPath();

//    String ALTERNATIVA=IFileManipulator.class
//            .getClassLoader()
//            .getResource("relativeFile.txt")
//            .getPath()
//            .replace("%20"," ");

    String ALTERNATIVA=IFileManipulator.class
            .getClassLoader()
            .getResource("relativeFile.txt")
            .getPath()
            .replaceFirst("/","");

    List<String> readFromFile(PathType pathType);

    void writeToFile(List<String> linesToWrite, boolean append);
}
