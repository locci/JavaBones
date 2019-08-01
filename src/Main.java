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


        //YamlPrinter printer = new YamlPrinter(true);
        FileManager fm = new FileManager();
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(null);

        if(returnVal == 1) {

            Exception e = new Exception();
            //throw e.getMessage("File not selected");

        }

        File pathDir = fc.getSelectedFile();
        ArrayList<String> path = fm.buildListOfFile(pathDir.getAbsolutePath());

        final String str = "/media/alexandre/MyFiles/IntellijWorkSpace/src/Simples.java";
        final Requirement re = new Requirement();
        re.buildListIfRequirement(str);
        List<String[]> listWhile = re.getListWhileRequirements();
        List<String[]> listIf    = re.getListIfRequirements();

        for(int i=0; i < listIf.size(); i++){

            String[] arr = listIf.get(i);

            for(String strOut: arr){
                System.out.println(strOut);
            }

        }

        //for(int j=0; j < listWhile.size(); j++) System.out.println(listWhile.get(j));


    }

}

