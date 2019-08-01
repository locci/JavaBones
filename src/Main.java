//import br.ime.usp.parser.compi.CompUnit;
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

        File pathDir = fc.getSelectedFile();
        ArrayList<String> path = fm.buildListOfFile(pathDir.getAbsolutePath());

        for (String pathFull : path) {

            System.out.println(pathFull + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            final Requirement re = new Requirement();
            re.buildListIfRequirement(pathFull);
            List<String[]> listWhile = re.getListWhileRequirements();
            List<String[]> listIf = re.getListIfRequirements();

            System.out.println("If");

            for (String[] arr : listIf) {

                for (String strOut : arr) {
                    System.out.println(strOut);
                }

            }

            System.out.println("While");

            for (String[] arr : listWhile) {

                for (String strOut : arr) {

                    System.out.println(strOut);

                }

            }

        }

    }

}

