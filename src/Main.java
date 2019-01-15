import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.printer.YamlPrinter;

import com.github.javaparser.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {


        YamlPrinter printer = new YamlPrinter(true);
        FileInputStream in = new FileInputStream("/media/alexandre/MyFiles/IntellijWorkSpace/src/Simples.java");
        FileWriter fw = new FileWriter("/media/alexandre/MyFiles/IntellijWorkSpace/out4");
        CompilationUnit cu = JavaParser.parse(in);

        List<IfStmt> listIf = cu.getChildNodesByType(IfStmt.class);

        for(IfStmt e: listIf) {

            System.out.println(e.getCondition());

        }


        Metrics ma = new Metrics();

        fw.write(printer.output(cu));
        fw.close();

        String str = printer.output(cu);

        if(ma.buildMetrics(str)) {

            System.out.println("OK");

        } else {

            System.out.println("NOK");

        }

    }

}

class MethodPrinter {

    public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("/home/alexandre/Desktop/teste/Main.java");
        CompilationUnit cu = JavaParser.parse(in);
        cu.accept(new MethodVisitor(),null);

    }

    /**
     * Simple visitor implementation for visiting MethodDeclaration nodes.
     */
    private static class MethodVisitor extends VoidVisitorAdapter<Void> {

        public void visit(MethodDeclaration n, Void arg) {
            System.out.println(n.getName());
            System.out.println(n.getBody());

            super.visit(n, arg);
        }
    }

}

class Metrics {

    public boolean buildMetrics (String str){

       String[] code;
       String className = "";
       String interfaceName = "";
       int cont = 0;

       code = str.split("\n");

        while(cont < code.length) {

           if(code[cont].contains("type(Type=ClassOrInterfaceDeclaration)")) {


               cont++;
               if(code[cont].contains("false")) {

                   cont= cont + 2;
                   className = code[cont].replace("identifier: \"", "");
                   className = className.replace("\"", "");
                   System.out.println("Class " + className);


               } else {

                    cont = cont + 2;
                    interfaceName = code[cont].replace("identifier: \"", "");
                    interfaceName = interfaceName.replace("\"", "");
                    System.out.println("Interface " + interfaceName);

               }

           }

           cont++;

       }


       return true;
    }

}