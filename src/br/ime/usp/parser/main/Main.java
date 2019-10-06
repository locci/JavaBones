package br.ime.usp.parser.main;//import br.ime.usp.parser.compi.CompUnit;
import br.ime.usp.parser.filemanager.FileManager;
import br.ime.usp.parser.requeriment.Requirement;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        FileManager fm = new FileManager();
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.showOpenDialog(null);
        fm.destroFile();
        int contIf    = 0;
        int contWhile = 0;
        File pathDir = fc.getSelectedFile();
        ArrayList<String> path = fm.buildListOfFile(pathDir.getAbsolutePath());
        fm.buildMetricFile("Total number of .java files: " + path.size());

        for (String pathFull : path) {

            fm.buidLogFile(pathFull + "  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            final Requirement re = new Requirement();
            re.buildListIfRequirement(pathFull);
            List<String[]> listWhile = re.getListWhileRequirements();
            List<String[]> listIf = re.getListIfRequirements();

            fm.buidLogFile("If");

            for (String[] arr : listIf) {

                for (String strOut : arr) {

                    fm.buidLogFile(strOut);

                }
                //fm.buidLogFile("total number: " + Integer.toString(arr.length));
                if (arr.length > 1) {
                    fm.buidLogFile("total number: " + Integer.toString(arr.length));
                    contIf = contIf + arr.length;
                } else {
                    if (arr[0].equals("")) {
                        fm.buidLogFile("total number: " + Integer.toString(0));
                    } else {
                        fm.buidLogFile("total number: " + Integer.toString(1));
                        contIf = contIf + 1;
                    }
                }
            }

            fm.buidLogFile("While");

            for (String[] arr : listWhile) {

                for (String strOut : arr) {

                    fm.buidLogFile(strOut);

                }
                if (arr.length > 1) {
                    fm.buidLogFile("total number: " + Integer.toString(arr.length));
                    contWhile = contWhile + arr.length;
                } else {
                    if (arr[0].equals("")) {
                        fm.buidLogFile("total number: " + Integer.toString(0));
                    } else {
                        fm.buidLogFile("total number: " + Integer.toString(1));
                        contWhile = contWhile + 1;
                    }
                }
            }

        }
        fm.buildMetricFile("Total of if branches: "    + contIf);
        fm.buildMetricFile("Total of while branches: " + contWhile);
    }

}

