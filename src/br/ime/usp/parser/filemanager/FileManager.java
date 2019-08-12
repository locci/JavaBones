package br.ime.usp.parser.filemanager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private ArrayList<String> outPutList = new ArrayList<>();

    public ArrayList<String> buildListOfFile (String path) {

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();


        if (listOfFiles!=null){

            for (File file : listOfFiles) {

                if (file.isFile()) {

                    if(file.getAbsolutePath().endsWith(".java")) {

                        outPutList.add(file.getAbsolutePath());

                    }

                } else {

                    buildListOfFile(file.getAbsolutePath());
                }

            }

        }

        return outPutList;

    }

    public void buidLogFile(String line){

        File fl = new File("logIfWhile");

        try {

            FileWriter fw = new FileWriter(fl, true) ;
            fw.write(line + "\n");
            fw.close();

        } catch (IOException e) {

            System.out.println("Erro na escrita do arquivo logIfWhile");
            e.printStackTrace();

        }

    }

    public void buidMetricFile(String line){

        File fl = new File("metricFile");

        try {

            FileWriter fw = new FileWriter(fl, true) ;
            fw.write(line + "\n");
            fw.close();

        } catch (IOException e) {

            System.out.println("Erro na escrita do arquivo metricFile");
            e.printStackTrace();

        }

    }

    public void destroFile() {

        File flLog = new File("logIfWhile");
        File flMetric = new File("metricFile");

        boolean delete = flLog.delete();

        if(delete) {

            System.out.println("Arquivo logIfWhile deletado.");

        }

        delete = flMetric.delete();

        if(delete) {

            System.out.println("Arquivo metricFile deletado.");

        }

    }

}
