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

        File pathDir = fc.getSelectedFile();
        ArrayList<String> path = fm.buildListOfFile(pathDir.getAbsolutePath());
        fm.buidMetricFile("Total number of files: " + path.size());

        for (String pathFull : path) {

            fm.buidLogFile(pathFull + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            final Requirement re = new Requirement();
            re.buildListIfRequirement(pathFull);
            List<String[]> listWhile = re.getListWhileRequirements();
            List<String[]> listIf = re.getListIfRequirements();

            fm.buidLogFile("If");

            for (String[] arr : listIf) {

                for (String strOut : arr) {

                    fm.buidLogFile(strOut);

                }

            }

            fm.buidLogFile("While");

            for (String[] arr : listWhile) {

                for (String strOut : arr) {

                    fm.buidLogFile(strOut);

                }

            }

        }

    }

}

