package com.sda.fisiere;

        import java.io.*;
        import java.util.LinkedList;
        import java.util.List;

public class LegacyFileManipulator implements IFileManipulator {
    @Override
    public List<String> readFromFile(PathType pathType) {
        List<String> result=new LinkedList<>();
        String path="";

        switch (pathType){
            case ABSOLUTE:
                path=ABSOLUTE_PATH;
                break;
            case RELATIVE:
                path=RELATIVE_PATH;
                break;
            default:
                System.out.println("Path received not recognized.");
        }

        try(BufferedReader inputStream=new BufferedReader(new FileReader(path))){
            String line=inputStream.readLine();
            while(line!=null){
                result.add(line);
                line=inputStream.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void writeToFile(List<String> linesToWrite, boolean append) {
        try(FileWriter fileWriter = new FileWriter(RELATIVE_PATH, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            for(String line:linesToWrite){
                printWriter.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
