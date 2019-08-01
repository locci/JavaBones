package br.ime.usp.parser.filemanager;

import java.io.File;
import java.util.ArrayList;

public class FileManager {

    private ArrayList<String> outPutList = new ArrayList<>();

    public ArrayList<String> buildListOfFile (String path) {

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        //ArrayList<String> outPutList = new ArrayList<>();



        for (File file : listOfFiles) {

            if (file.isFile()) {

                outPutList.add(file.getAbsolutePath());

            } else {

                buildListOfFile(file.getAbsolutePath());

            }

        }

        return outPutList;

    }

}
