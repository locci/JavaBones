package br.ime.usp.parser.main;//import br.ime.usp.parser.compi.CompUnit;
import br.ime.usp.parser.Statistic;
import br.ime.usp.parser.filemanager.CsvFile;
import br.ime.usp.parser.filemanager.FileManager;
import br.ime.usp.parser.filemanager.PlotFile;
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
        fm.destroyFile();
        int contIf    = 0;
        int contWhile = 0;
        int contFor   = 0;
        File pathDir = fc.getSelectedFile();
        ArrayList<String> path = fm.buildListOfFile(pathDir.getAbsolutePath());
        fm.buildMetricFile("Total number of .java files: " + path.size());
        List<Integer> dataLinesIf = new ArrayList<>();
        List<Integer> dataLinesWhile = new ArrayList<>();
        List<Integer> dataLinesFor = new ArrayList<>();
        CsvFile csv = new CsvFile();
        PlotFile plot = new PlotFile();
        Statistic stat = new Statistic();

        for (String pathFull : path) {

            fm.buildLogFile(pathFull + "  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            final Requirement re = new Requirement();
            re.buildListIfRequirement(pathFull);
            List<String[]> listWhile = re.getListWhileRequirements();
            List<String[]> listIf = re.getListIfRequirements();
            List<String[]> listFor = re.getListForRequirements();

            fm.buildLogFile("If");

            for (String[] arr : listIf) {

                for (String strOut : arr) {

                    fm.buildLogFile(strOut);

                }
                if (arr.length > 1) {
                    fm.buildLogFile("total number: " + Integer.toString(arr.length));
                    contIf = contIf + arr.length;
                    dataLinesIf.add(arr.length);
                } else {
                    if (arr[0].equals("")) {
                        fm.buildLogFile("total number: " + Integer.toString(0));
                        dataLinesIf.add(0);
                    } else {
                        fm.buildLogFile("total number: " + Integer.toString(1));
                        contIf = contIf + 1;
                        dataLinesIf.add(1);
                    }
                }
            }

            fm.buildLogFile("While");

            for (String[] arr : listWhile) {

                for (String strOut : arr) {

                    fm.buildLogFile(strOut);

                }
                if (arr.length > 1) {
                    fm.buildLogFile("total number: " + Integer.toString(arr.length));
                    contWhile = contWhile + arr.length;
                    dataLinesWhile.add(arr.length);
                } else {
                    if (arr[0].equals("")) {
                        fm.buildLogFile("total number: " + Integer.toString(0));
                        dataLinesWhile.add(0);
                    } else {
                        fm.buildLogFile("total number: " + Integer.toString(1));
                        contWhile = contWhile + 1;
                        dataLinesWhile.add(1);
                    }
                }
            }

            fm.buildLogFile("For");

            for (String[] arr : listFor) {

                for (String strOut : arr) {

                    fm.buildLogFile(strOut);

                }
                if (arr.length > 1) {
                    fm.buildLogFile("total number: " + Integer.toString(arr.length));
                    contFor = contFor + arr.length;
                    dataLinesFor.add(arr.length);
                } else {
                    if (arr[0].equals("")) {
                        fm.buildLogFile("total number: " + Integer.toString(0));
                        dataLinesFor.add(0);
                    } else {
                        fm.buildLogFile("total number: " + Integer.toString(1));
                        contFor = contFor + 1;
                        dataLinesFor.add(1);
                    }
                }
            }

        }

        fm.buildMetricFile("Total of if branches: "    + contIf);
        fm.buildMetricFile("Total of while branches: " + contWhile);
        fm.buildMetricFile("Total of for branches: " + contFor);
        csv.buildCSVFile(dataLinesIf, "If");
        plot.buildPlotsHistogram("csvIf.csv", "if");
        plot.buildBoxPlot("csvIf.csv", "if");
        stat.buildBasicStatistics("csvIf.csv");
        csv.buildCSVFile(dataLinesWhile, "While");
        plot.buildPlotsHistogram("csvWhile.csv", "while");
        plot.buildBoxPlot("csvWhile.csv", "while");
        csv.buildCSVFile(dataLinesFor, "For");
        plot.buildPlotsHistogram("csvFor.csv", "for");
        plot.buildBoxPlot("csvFor.csv", "for");
        dataLinesFor.clear();
        dataLinesIf.clear();
        dataLinesWhile.clear();

    }

}

